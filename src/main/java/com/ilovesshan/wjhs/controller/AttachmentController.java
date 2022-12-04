package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AttachmentConverter;
import com.ilovesshan.wjhs.beans.pojo.Attachment;
import com.ilovesshan.wjhs.service.AttachmentService;
import com.ilovesshan.wjhs.utils.R;
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

@RestController
@RequestMapping("attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private AttachmentConverter attachmentConverter;

    @PostMapping
    public R upload(@RequestParam("file") MultipartFile file) {
        String attachmentId = attachmentService.upload(file);
        Attachment attachment = attachmentService.selectById(attachmentId);
        return R.success(R.SUCCESS_ATTACHMENT_UPLOAD, attachmentConverter.po2vo(attachment));
    }

    @GetMapping("/{id}")
    public R select(@PathVariable String id) {
        Attachment attachment = attachmentService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, attachmentConverter.po2vo(attachment));
    }

    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        attachmentService.deleteById(id);
        return R.success(R.SUCCESS_MESSAGE_DELETE);
    }
}
