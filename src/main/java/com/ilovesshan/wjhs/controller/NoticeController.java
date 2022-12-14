package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.NoticeConverter;
import com.ilovesshan.wjhs.beans.dto.NoticeCreateDto;
import com.ilovesshan.wjhs.beans.dto.NoticeSelectDto;
import com.ilovesshan.wjhs.beans.dto.NoticeUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Notice;
import com.ilovesshan.wjhs.beans.vo.NoticeVo;
import com.ilovesshan.wjhs.service.NoticeService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/4
 * @description:
 */

@Api(tags = "公告模块")
@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private NoticeConverter noticeConverter;

    @GetMapping("/{id}")
    @ApiOperation("根据ID查询公告")
    public R selectById(@PathVariable String id) {
        Notice notice = noticeService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, noticeConverter.po2vo(notice));
    }


    @GetMapping
    @ApiOperation("查询公告")
    public R selectByConditions(@Validated NoticeSelectDto noticeSelectDto) {
        List<Notice> notices = noticeService.selectByConditions(noticeSelectDto);
        List<NoticeVo> noticesVos = notices.stream().map(noticeConverter::po2vo).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, noticesVos);
    }


    @PostMapping
    @ApiOperation("创建公告")
    public R create(@Validated @RequestBody NoticeCreateDto noticeCreateDto) {
        boolean isSuccess = noticeService.create(noticeCreateDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }


    @PutMapping
    @ApiOperation("更新公告")
    public R update(@Validated @RequestBody NoticeUpdateDto noticeUpdateDto) {
        boolean isSuccess = noticeService.update(noticeUpdateDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }


    @DeleteMapping("/{id}")
    @ApiOperation("根据ID删除")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = noticeService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }
}
