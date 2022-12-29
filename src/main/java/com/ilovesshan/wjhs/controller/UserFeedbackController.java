package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.dto.UserFeedbackDto;
import com.ilovesshan.wjhs.beans.pojo.UserFeedback;
import com.ilovesshan.wjhs.beans.vo.UserFeedbackVo;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.UserFeedbackService;
import com.ilovesshan.wjhs.utils.R;
import com.ilovesshan.wjhs.utils.UserFeedbackVoParseUtil;
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
 * @date: 2022/12/29
 * @description:
 */

@Api(tags = "用户反馈模块")
@RestController
@RequestMapping("/feedback")
public class UserFeedbackController {

    @Autowired
    private UserFeedbackService userFeedbackService;

    @Autowired
    private UserFeedbackVoParseUtil userFeedbackVoParseUtil;


    @ApiOperation("根据用户ID获取反馈列表")
    @GetMapping("/{userId}")
    public R selectListByUserId(@PathVariable String userId) {
        List<UserFeedback> userFeedbacks = userFeedbackService.selectListByUserId(userId);
        List<UserFeedbackVo> userFeedbackVos = userFeedbackVoParseUtil.parseList(userFeedbacks);
        return R.success(R.SUCCESS_MESSAGE_SELECT, userFeedbackVos);
    }


    @ApiOperation("根据用户类型获取反馈列表")
    @GetMapping
    public R selectListByType(@RequestParam String type) {
        List<UserFeedback> userFeedbacks = userFeedbackService.selectListByType(type);
        List<UserFeedbackVo> userFeedbackVos = userFeedbackVoParseUtil.parseList(userFeedbacks);
        return R.success(R.SUCCESS_MESSAGE_SELECT, userFeedbackVos);
    }


    @Log(businessModule = "用户反馈模块", businessType = "POST", businessDescribe = "新增反馈")
    @ApiOperation("新增反馈")
    @PostMapping
    public R create(@Validated @RequestBody UserFeedbackDto userFeedbackDto) {
        boolean isSuccess = userFeedbackService.create(userFeedbackDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }

    @Log(businessModule = "用户反馈模块", businessType = "PUT", businessDescribe = "更新反馈状态(已处理)")
    @ApiOperation("更新反馈状态(已处理)")
    @PutMapping("/{id}")
    public R updateIsSolveDone(@PathVariable String id) {
        boolean isSuccess = userFeedbackService.updateIsSolveDone(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }


    @Log(businessModule = "用户反馈模块", businessType = "DELETE", businessDescribe = "根据ID删除用户反馈")
    @ApiOperation("根据ID删除用户反馈")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = userFeedbackService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }
}
