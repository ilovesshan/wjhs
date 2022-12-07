package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AttachmentConverter;
import com.ilovesshan.wjhs.beans.converter.SwiperConverter;
import com.ilovesshan.wjhs.beans.dto.SwiperCreateDto;
import com.ilovesshan.wjhs.beans.dto.SwiperSelectDto;
import com.ilovesshan.wjhs.beans.dto.SwiperUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Swiper;
import com.ilovesshan.wjhs.beans.vo.SwiperVo;
import com.ilovesshan.wjhs.service.SwiperService;
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

@Api(tags = "轮播图模块")
@RestController
@RequestMapping("/swiper")
public class SwiperController {

    @Autowired
    private SwiperService swiperService;

    @Autowired
    private SwiperConverter swiperConverter;

    @Autowired
    private AttachmentConverter attachmentConverter;


    @ApiOperation("根据ID获取轮播图")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        Swiper swiper = swiperService.selectById(id);
        SwiperVo swiperVo = swiperConverter.po2vo(swiper);
        swiperVo.setAttachment(attachmentConverter.po2vo(swiper.getAttachment()));
        return R.success(R.SUCCESS_MESSAGE_SELECT, swiperVo);
    }


    @ApiOperation("获取轮播图")
    @GetMapping
    public R selectByConditions(@Validated SwiperSelectDto swiperSelectDto) {
        List<Swiper> swipers = swiperService.selectByConditions(swiperSelectDto);
        List<SwiperVo> swiperVos = swipers.stream().map(swiper -> {
            SwiperVo swiperVo = swiperConverter.po2vo(swiper);
            swiperVo.setAttachment(attachmentConverter.po2vo(swiper.getAttachment()));
            return swiperVo;
        }).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, swiperVos);
    }


    @ApiOperation("创建轮播图")
    @PostMapping
    public R create(@Validated @RequestBody SwiperCreateDto swiperCreateDto) {
        boolean isSuccess = swiperService.create(swiperCreateDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }


    @ApiOperation("更新轮播图")
    @PutMapping
    public R update(@Validated @RequestBody SwiperUpdateDto swiperUpdateDto) {
        boolean isSuccess = swiperService.update(swiperUpdateDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }

    @ApiOperation("删除轮播图")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = swiperService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }
}
