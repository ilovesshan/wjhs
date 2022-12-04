package com.ilovesshan.wjhs.service;

import com.ilovesshan.wjhs.beans.pojo.Attachment;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */
public interface AttachmentService {
    String upload(MultipartFile multipartFile);

    boolean saveAttachment(Attachment attachment);

    Attachment selectById(String id);

    boolean deleteById(String id);
}
