package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AttachmentConverter;
import com.ilovesshan.wjhs.beans.converter.RecycleGoodsConverter;
import com.ilovesshan.wjhs.beans.dto.RecycleGoodsCreateDto;
import com.ilovesshan.wjhs.beans.dto.RecycleGoodsUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoods;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsAndType;
import com.ilovesshan.wjhs.beans.vo.RecycleGoodsAndTypeVo;
import com.ilovesshan.wjhs.beans.vo.RecycleGoodsVo;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.RecycleGoodsService;
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
 * @date: 2022/12/11
 * @description:
 */

@Api(tags = "回收商品模块")
@RestController
@RequestMapping("/RecycleGoods")
public class RecycleGoodsController {

    @Autowired
    private RecycleGoodsService recycleGoodsService;

    @Autowired
    private RecycleGoodsConverter recycleGoodsConverter;

    @Autowired
    private AttachmentConverter attachmentConverter;


    @ApiOperation("查询全部类型下的商品列表")
    @GetMapping("/all")
    public R selectListAllWithType() {
        List<RecycleGoodsAndType> recycleGoodsAndTypes = recycleGoodsService.selectAllListWithType();
        List<RecycleGoodsAndTypeVo> goodsAndTypeVos = recycleGoodsAndTypes.stream().map(recycleGoodsAndType -> {
            RecycleGoodsAndTypeVo recycleGoodsAndTypeVo = recycleGoodsConverter.po2vo(recycleGoodsAndType);
            List<RecycleGoodsVo> recycleGoodsVoList = recycleGoodsAndType.getRecycleGoods().stream().map(recycleGoods -> {
                RecycleGoodsVo recycleGoodsVo = recycleGoodsConverter.po2vo(recycleGoods);
                recycleGoodsVo.setAttachment(attachmentConverter.po2vo(recycleGoods.getAttachment()));
                return recycleGoodsVo;
            }).collect(Collectors.toList());
            recycleGoodsAndTypeVo.setRecycleGoods(recycleGoodsVoList);
            return recycleGoodsAndTypeVo;
        }).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, goodsAndTypeVos);
    }


    @ApiOperation("根据类型获取商品列表")
    @GetMapping
    public R selectListByType(@RequestParam String type) {
        List<RecycleGoods> recycleGoods = recycleGoodsService.selectListByType(type);
        List<RecycleGoodsVo> recycleGoodsVos = recycleGoods.stream().map(recycleGoodsItem -> {
            RecycleGoodsVo recycleGoodsVo = recycleGoodsConverter.po2vo(recycleGoodsItem);
            recycleGoodsVo.setAttachment(attachmentConverter.po2vo(recycleGoodsItem.getAttachment()));
            return recycleGoodsVo;
        }).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, recycleGoodsVos);
    }

    @ApiOperation("根据ID获取商品详情")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        RecycleGoods recycleGoods = recycleGoodsService.selectById(id);
        RecycleGoodsVo recycleGoodsVo = recycleGoodsConverter.po2vo(recycleGoods);
        recycleGoodsVo.setAttachment(attachmentConverter.po2vo(recycleGoods.getAttachment()));
        return R.success(R.SUCCESS_MESSAGE_SELECT, recycleGoodsVo);
    }

    @Log(businessModule = "回收商品模块", businessType = "DELETE", businessDescribe = "根据ID删除商品")
    @ApiOperation("根据ID删除商品")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = recycleGoodsService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }

    @Log(businessModule = "回收商品模块", businessType = "INSERT", businessDescribe = "新增商品")
    @ApiOperation("新增商品")
    @PostMapping()
    public R insert(@Validated @RequestBody RecycleGoodsCreateDto recycleGoodsCreateDto) {
        boolean isSuccess = recycleGoodsService.insert(recycleGoodsConverter.dto2po(recycleGoodsCreateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }

    @Log(businessModule = "回收商品模块", businessType = "UPDATE", businessDescribe = "更新商品")
    @ApiOperation("更新商品")
    @PutMapping()
    public R update(@Validated @RequestBody RecycleGoodsUpdateDto recycleGoodsUpdateDto) {
        boolean isSuccess = recycleGoodsService.update(recycleGoodsConverter.dto2po(recycleGoodsUpdateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }
}
