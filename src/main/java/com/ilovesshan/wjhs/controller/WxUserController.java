package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.WxUserConverter;
import com.ilovesshan.wjhs.beans.dto.WxUserUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.beans.vo.WxUserVo;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.WxUserService;
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
 * @date: 2022/11/30
 * @description:
 */

@Api(tags = "小程序用户模块")
@RestController
@RequestMapping("/wx/users")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;

    @Autowired
    private WxUserConverter wxUserConverter;

    @ApiOperation("根据ID获取用户信息")
    @GetMapping("/{id}")
    public R auth(@PathVariable String id) {
        WxUser wxUser = wxUserService.findUserById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, wxUserConverter.po2vo(wxUser));
    }

    @ApiOperation("更新用户信息")
    @PostMapping
    public R update(@Validated @RequestBody WxUserUpdateDto wxUserUpdateDto) {
        boolean isSuccess = wxUserService.update(wxUserConverter.dto2po(wxUserUpdateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.SUCCESS_MESSAGE_UPDATE);
    }


    @ApiOperation("获取小程序用户列表")
    @GetMapping
    public R selectList() {
        List<WxUser> wxUsers = wxUserService.selectList();
        List<WxUserVo> wxUserVos = wxUsers.stream().map(wxUserConverter::po2vo).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, wxUserVos);
    }

    @Log(businessModule = "小程序用户模块", businessType = "DELETE", businessDescribe = "根据ID删除用户")
    @ApiOperation("根据ID删除用户")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = wxUserService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }

}
