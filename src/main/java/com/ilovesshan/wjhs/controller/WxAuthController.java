package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.WxUserConverter;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.service.WxAuthService;
import com.ilovesshan.wjhs.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Api(tags = "小程序授权模块")
@RestController
@RequestMapping("/wx/auth")
public class WxAuthController {

    @Autowired
    private WxAuthService wxAuthService;

    @Autowired
    private WxUserConverter wxUserConverter;

    @ApiOperation("授权")
    @PostMapping
    public R auth(@RequestParam(value = "code") String code) {
        WxUser wxUser = wxAuthService.auth(code);
        return R.success(R.SUCCESS_MESSAGE_LOGIN, wxUserConverter.po2AuthVo(wxUser));
    }
}
