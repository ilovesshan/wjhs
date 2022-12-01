package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.WxUserConverter;
import com.ilovesshan.wjhs.beans.dto.WxUserUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.WxUser;
import com.ilovesshan.wjhs.service.WxUserService;
import com.ilovesshan.wjhs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@RestController
@RequestMapping("/wx/users")
public class WxUserController {

    @Autowired
    private WxUserService wxUserService;

    @Autowired
    private WxUserConverter wxUserConverter;

    @GetMapping("/{id}")
    public R auth(@PathVariable String id) {
        WxUser wxUser = wxUserService.findUserById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, wxUserConverter.po2vo(wxUser));
    }

    @PostMapping
    public R update(@Validated @RequestBody WxUserUpdateDto wxUserUpdateDto) {
        boolean isSuccess = wxUserService.update(wxUserConverter.dto2po(wxUserUpdateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.SUCCESS_MESSAGE_UPDATE);
    }
}
