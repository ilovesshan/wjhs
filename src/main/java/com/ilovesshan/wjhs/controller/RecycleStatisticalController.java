package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.vo.RecycleStatisticalVo;
import com.ilovesshan.wjhs.service.RecycleStatisticalService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/27
 * @description:
 */

@Api(tags = "回收商品统计模块")
@RestController
@RequestMapping("/recycle/statistical")
public class RecycleStatisticalController {

    @Autowired
    private RecycleStatisticalService recycleStatisticalService;

    @ApiOperation("根据订单类型查询统计记录")
    @GetMapping()
    public R selectByType(@RequestParam("orderType") String orderType, @RequestParam("userType") String userType) {
        RecycleStatisticalVo RecycleStatisticalVo = recycleStatisticalService.selectByType(orderType, userType);
        return R.success(R.SUCCESS_MESSAGE_SELECT, RecycleStatisticalVo);
    }
}
