package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.dto.RecycleOrderUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.RecycleOrder;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.core.base.UserCache;
import com.ilovesshan.wjhs.service.RecycleOrderService;
import com.ilovesshan.wjhs.service.WxRecycleOrderService;
import com.ilovesshan.wjhs.utils.OrderVoParseUtil;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/16
 * @description:
 */


@Api(tags = "回收商品订单模块")
@RestController
@RequestMapping("/recycleOrders")
public class RecycleOrderController {

    @Autowired
    private RecycleOrderService recycleOrderService;

    @Autowired
    private WxRecycleOrderService wxRecycleOrderService;

    @Autowired
    private OrderVoParseUtil orderVoParseUtil;

    @ApiOperation("查询骑手相关的订单列表")
    @GetMapping("/driver")
    public R selectListByStatus(@RequestParam(required = false) String type, @RequestParam(required = false) String status) {
        List<RecycleOrder> recycleOrders = null;
        switch (type) {
            case "1":
                // 小程序发出的订单  status(根据查询条件传参)、orderType=10(用户到骑手)、userId(与我相关的订单信息)
                recycleOrders = recycleOrderService.selectListByStatusAndOrderTypeAndUserId(status, "10", UserCache.get("userId"));
                break;
            case "2":
                // 我发出的订单  orderType=11(骑手到回收中心)、userId(与我相关的订单信息)
                // recycleOrders = recycleOrderService.selectListByOrderTypeAndUserId("11", UserCache.get("userId"));
                recycleOrders = recycleOrderService.selectListByStatusAndOrderTypeAndUserId(status, "11", UserCache.get("userId"));
                break;
            default:
                // 查询全部  status=4(待接单)、orderType=10(用户到骑手)
                recycleOrders = recycleOrderService.selectListByStatusAndOrderType("4", "10");
        }
        return R.success(R.SUCCESS_MESSAGE_SELECT, orderVoParseUtil.parseList(recycleOrders));
    }


    @ApiOperation("查询回收中心相关的订单列表")
    @GetMapping("/recycleCenter")
    public R selectListByStatus( @RequestParam String status) {
        // orderType=11(骑手到回收中心)、 status=6(进行中), 7(已完结)
        List<RecycleOrder> recycleOrders = recycleOrderService.selectListByStatusAndOrderType(status, "11");
        return R.success(R.SUCCESS_MESSAGE_SELECT, orderVoParseUtil.parseList(recycleOrders));
    }


    @ApiOperation("查询平台端相关的订单列表")
    @GetMapping("/platform")
    public R selectList(String status, @RequestParam String orderType) {
        // 查全部  status(根据查询条件传参)、orderType(根据查询条件传参)
        List<RecycleOrder> recycleOrders = recycleOrderService.selectListByStatusAndOrderType(status, orderType);
        return R.success(R.SUCCESS_MESSAGE_SELECT, orderVoParseUtil.parseList(recycleOrders));
    }


    @ApiOperation("根据ID查询订单详情")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        RecycleOrder recycleOrder = wxRecycleOrderService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, orderVoParseUtil.parseSingle(recycleOrder));
    }


    @Log(businessModule = "回收商品订单模块", businessType = "DELETE", businessDescribe = "根据ID删除订单")
    @ApiOperation("根据ID删除订单")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = wxRecycleOrderService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }


    @Log(businessModule = "回收商品订单模块", businessType = "PUT", businessDescribe = "更新订单状态")
    @ApiOperation("更新订单状态")
    @PutMapping
    public R update(@Validated @RequestBody RecycleOrderUpdateDto recycleOrderUpdateDto) {
        boolean isSuccess = wxRecycleOrderService.updateOrderStatus(recycleOrderUpdateDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }


    @Log(businessModule = "回收商品订单模块", businessType = "PUT", businessDescribe = "订单送至回收中心")
    @ApiOperation("订单送至回收中心")
    @PutMapping("/{id}")
    public R sendRecycleGoodsOrderToRecycleCenter(@PathVariable("id") String orderId, @RequestParam("receiveUserId") String receiveUserId) {
        boolean isSuccess = wxRecycleOrderService.sendRecycleGoodsOrderToRecycleCenter(orderId, receiveUserId);
        return isSuccess ? R.success(R.ERROR_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }


    @Log(businessModule = "回收商品订单模块", businessType = "POST", businessDescribe = "订单支付")
    @ApiOperation("订单支付")
    @PostMapping("/pay/{orderId}")
    public R orderPay(@PathVariable String orderId) {
        boolean isSuccess = wxRecycleOrderService.orderPay(orderId);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE) : R.fail(R.ERROR_MESSAGE);
    }
}
