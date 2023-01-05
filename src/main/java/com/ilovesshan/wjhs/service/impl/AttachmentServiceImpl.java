package com.ilovesshan.wjhs.service.impl;

import com.ilovesshan.wjhs.beans.pojo.Attachment;
import com.ilovesshan.wjhs.contants.Constants;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.core.exception.CustomException;
import com.ilovesshan.wjhs.mapper.AttachmentMapper;
import com.ilovesshan.wjhs.service.AttachmentService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.SystemUtil;
import com.ilovesshan.wjhs.utils.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Service
@Slf4j
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public String upload(MultipartFile multipartFile) {
        // 区分当前运行的系统环境
        File fileDir = new File(SystemUtil.isWindows() ? Constants.ATTACHMENT_UPLOAD_WINDOWS_DEST : Constants.ATTACHMENT_UPLOAD_LINUX_DEST);

        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        // 获取文件扩展名
        String ext = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        // 文件名称
        String fileName = UuidUtil.generator() + ext;

        try {
            multipartFile.transferTo(new File(fileDir + File.separator + fileName));
        } catch (IOException e) {
            e.printStackTrace();
            throw new CustomException(R.ERROR_ATTACHMENT_UPLOAD);
        }

        // 组装一个Attachment对象 新增到数据库
        Attachment attachment = new Attachment();
        attachment.setId(UuidUtil.generator());
        attachment.setUrl(Constants.ATTACHMENT_PREVIEW_PREFIX + fileName);
        attachment.setCreateByUserId(UserCache.get("userId"));
        attachment.setCreateByUserName(UserCache.get("username"));
        attachment.setCreateByUserType(UserCache.get("userType"));
        saveAttachment(attachment);
        return attachment.getId();
    }


    @Override
    public boolean saveAttachment(Attachment attachment) {
        return attachmentMapper.insert(attachment) > 0;
    }

    @Override
    public Attachment selectById(String id) {
        return attachmentMapper.selectById(id);
    }

    @Override
    public boolean deleteById(String id) {
        Attachment finedAttachment = selectById(id);
        if (Objects.isNull(finedAttachment)) {
            throw new CustomException(R.ERROR_ATTACHMENT_NOTFOUND);
        }

        String filePath = (SystemUtil.isWindows() ? Constants.ATTACHMENT_UPLOAD_WINDOWS_DEST : Constants.ATTACHMENT_UPLOAD_LINUX_DEST) + finedAttachment.getUrl();
        // 删除本地文件  替换掉 "//preview" 预览前缀
        boolean deleteSuccess = new File(filePath.replace("//preview", "")).delete();
        if (deleteSuccess) {
            // 删除数据库文件
            return attachmentMapper.deleteById(id) > 0;
        } else {
            throw new CustomException(R.ERROR_MESSAGE_DELETE);
        }
    }
}
