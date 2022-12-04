package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AttachmentConverter;
import com.ilovesshan.wjhs.beans.pojo.Attachment;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.AttachmentService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Api(tags = "附件模块")
@RestController
@RequestMapping("attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private AttachmentConverter attachmentConverter;

    @ApiOperation("上传附件")
    @PostMapping
    @Log(businessModule = "附件模块", businessType = "POST", businessDescribe = "上传附件")
    public R upload(@RequestParam("file") MultipartFile file) {
        String attachmentId = attachmentService.upload(file);
        Attachment attachment = attachmentService.selectById(attachmentId);
        return R.success(R.SUCCESS_ATTACHMENT_UPLOAD, attachmentConverter.po2vo(attachment));
    }


    @ApiOperation("根据ID查询附件")
    @GetMapping("/{id}")
    public R select(@PathVariable String id) {
        Attachment attachment = attachmentService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, attachmentConverter.po2vo(attachment));
    }


    @Log(businessModule = "附件模块", businessType = "DELETE", businessDescribe = "根据ID删除附件")
    @ApiOperation("根据ID删除附件")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        attachmentService.deleteById(id);
        return R.success(R.SUCCESS_MESSAGE_DELETE);
    }
}
