package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.RecycleOrderConverter;
import com.ilovesshan.wjhs.beans.converter.RecycleOrderDetailConverter;
import com.ilovesshan.wjhs.beans.dto.RecycleOrderCreateDto;
import com.ilovesshan.wjhs.beans.dto.RecycleOrderUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrderDetail;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.WxRecycleOrderService;
import com.ilovesshan.wjhs.utils.OrderVoParseUtil;
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
 * @date: 2022/12/16
 * @description:
 */


@Api(tags = "回收商品订单模块")
@RestController
@RequestMapping("/wx/recycleOrders")
public class WxRecycleOrderController {

    @Autowired
    private WxRecycleOrderService recycleOrderService;

    @Autowired
    private RecycleOrderConverter recycleOrderConverter;

    @Autowired
    private RecycleOrderDetailConverter recycleOrderDetailConverter;

    @Autowired
    private OrderVoParseUtil orderVoParseUtil;


    @ApiOperation("根据ID查询订单详情")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        RecycleOrder recycleOrder = recycleOrderService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, orderVoParseUtil.parseSingle(recycleOrder));
    }

    @ApiOperation("查询订单列表")
    @GetMapping
    public R selectList(@RequestParam String status) {
        List<RecycleOrder> recycleOrders = recycleOrderService.selectListByStatus(status);
        return R.success(R.SUCCESS_MESSAGE_SELECT, orderVoParseUtil.parseList(recycleOrders));
    }


    @Log(businessModule = "回收商品订单模块", businessType = "DELETE", businessDescribe = "根据ID删除订单")
    @ApiOperation("根据ID删除订单")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = recycleOrderService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }


    @Log(businessModule = "回收商品订单模块", businessType = "POST", businessDescribe = "新增订单")
    @ApiOperation("新增订单")
    @PostMapping
    public R create(@Validated @RequestBody RecycleOrderCreateDto recycleOrderCreateDto) {
        RecycleOrder recycleOrder = recycleOrderConverter.dto2po(recycleOrderCreateDto);
        List<RecycleOrderDetail> recycleOrderDetails = recycleOrderCreateDto.getGoodsList().stream().map(recycleOrderDetailConverter::dto2po).collect(Collectors.toList());
        recycleOrder.setRecycleOrderDetails(recycleOrderDetails);
        boolean isSuccess = recycleOrderService.create(recycleOrder);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }


    @Log(businessModule = "回收商品订单模块", businessType = "PUT", businessDescribe = "更新订单状态")
    @ApiOperation("更新订单状态")
    @PutMapping
    public R update(@Validated @RequestBody RecycleOrderUpdateDto recycleOrderUpdateDto) {
        boolean isSuccess = recycleOrderService.updateOrderStatus(recycleOrderUpdateDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }

}
