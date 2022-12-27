package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.WxIntegralConverter;
import com.ilovesshan.wjhs.beans.converter.WxIntegralRecordConverter;
import com.ilovesshan.wjhs.beans.pojo.UserIntegral;
import com.ilovesshan.wjhs.beans.pojo.WxIntegral;
import com.ilovesshan.wjhs.beans.vo.UserIntegralVo;
import com.ilovesshan.wjhs.beans.vo.WxIntegralRecordVo;
import com.ilovesshan.wjhs.beans.vo.WxIntegralVo;
import com.ilovesshan.wjhs.service.WxIntegralService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/12/25
 * @description:
 */

@Api(tags = "积分模块")
@RestController
@RequestMapping("/wx/integrals")
public class WxIntegralController {

    @Autowired
    private WxIntegralService wxIntegralService;

    @Autowired
    private WxIntegralConverter wxIntegralConverter;

    @Autowired
    private WxIntegralRecordConverter wxIntegralRecordConverter;


    @ApiOperation("根据ID查询账户积分和流水记录")
    @GetMapping("/{id}")
    public R selectByUserId(@PathVariable String id) {
        WxIntegral wxIntegral = wxIntegralService.selectByUserId(id);
        WxIntegralVo wxIntegralVo = wxIntegralConverter.po2vo(wxIntegral);
        List<WxIntegralRecordVo> wxIntegralRecordVos = wxIntegral.getIntegralRecords().stream().map(wxIntegralRecordConverter::po2vo).collect(Collectors.toList());
        wxIntegralVo.setIntegralRecords(wxIntegralRecordVos);
        return R.success(R.SUCCESS_MESSAGE_SELECT, wxIntegralVo);
    }

    @ApiOperation("查询用户账户积分和流水记录列表")
    @GetMapping
    public R selectListByType() {
        List<UserIntegral> userIntegrals = wxIntegralService.selectList();
        List<UserIntegralVo> userAccountVos = userIntegrals.stream().map(integral -> {
            UserIntegralVo userIntegralVo = wxIntegralConverter.po2vo(integral);
            // 积分的流水记录可能为空
            if (Objects.isNull(integral.getIntegralRecords())) {
                userIntegralVo.setIntegralRecords(Collections.emptyList());
            } else {
                userIntegralVo.setIntegralRecords(integral.getIntegralRecords().stream().map(wxIntegralRecordConverter::po2vo).collect(Collectors.toList()));
            }
            return userIntegralVo;
        }).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, userAccountVos);
    }
}
