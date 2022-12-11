package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.RecycleGoodsTypeConverter;
import com.ilovesshan.wjhs.beans.dto.RecycleGoodsTypeCreateDto;
import com.ilovesshan.wjhs.beans.dto.RecycleGoodsTypeUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleGoodsType;
import com.ilovesshan.wjhs.beans.vo.RecycleGoodsTypeVo;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.RecycleGoodsTypeService;
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

@Api(tags ="回收商品分类模块")
@RestController
@RequestMapping("/RecycleGoodsTypes")
public class RecycleGoodsTypeController {

    @Autowired
    private RecycleGoodsTypeService recycleGoodsTypeService;
    @Autowired
    private RecycleGoodsTypeConverter recycleGoodsTypeConverter;


    @ApiOperation("获取分类列表")
    @GetMapping
    public R selectList() {
        List<RecycleGoodsType> recycleGoodsTypes = recycleGoodsTypeService.selectList();
        List<RecycleGoodsTypeVo> recycleGoodsTypeVos = recycleGoodsTypes.stream().map(recycleGoodsTypeConverter::po2vo).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, recycleGoodsTypeVos);
    }

    @ApiOperation("根据ID获取分类详情")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        RecycleGoodsType recycleGoodsType = recycleGoodsTypeService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, recycleGoodsTypeConverter.po2vo(recycleGoodsType));
    }

    @Log(businessModule = "回收商品分类模块", businessType = "DELETE", businessDescribe = "根据ID删除分类")
    @ApiOperation("根据ID删除分类")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = recycleGoodsTypeService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }

    @Log(businessModule = "回收商品分类模块", businessType = "INSERT", businessDescribe = "新增商品分类")
    @ApiOperation("新增商品分类")
    @PostMapping()
    public R insert(@Validated @RequestBody RecycleGoodsTypeCreateDto recycleGoodsTypeCreateDto) {
        boolean isSuccess = recycleGoodsTypeService.insert(recycleGoodsTypeConverter.dto2po(recycleGoodsTypeCreateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }

    @Log(businessModule = "回收商品分类模块", businessType = "UPDATE", businessDescribe = "更新商品分类")
    @ApiOperation("更新商品分类")
    @PutMapping()
    public R update(@Validated @RequestBody RecycleGoodsTypeUpdateDto recycleGoodsTypeUpdateDto) {
        boolean isSuccess = recycleGoodsTypeService.update(recycleGoodsTypeConverter.dto2po(recycleGoodsTypeUpdateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }
}
