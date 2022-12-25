package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AccountConverter;
import com.ilovesshan.wjhs.beans.converter.AccountRecordConverter;
import com.ilovesshan.wjhs.beans.dto.AccountRecordCreateDto;
import com.ilovesshan.wjhs.beans.pojo.Account;
import com.ilovesshan.wjhs.beans.vo.AccountRecordVo;
import com.ilovesshan.wjhs.beans.vo.AccountVo;
import com.ilovesshan.wjhs.core.annotation.Log;
import com.ilovesshan.wjhs.service.AccountService;
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
 * @date: 2022/12/25
 * @description:
 */

@Api(tags = "账户模块")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountConverter accountConverter;

    @Autowired
    private AccountRecordConverter accountRecordConverter;


    @ApiOperation("根据ID查询账户余额和流水记录")
    @GetMapping("/{id}")
    public R selectByUserId(@PathVariable String id) {
        Account account = accountService.selectByUserId(id);
        AccountVo accountVo = accountConverter.po2vo(account);
        List<AccountRecordVo> accountRecordVos = account.getAccountRecords().stream().map(accountRecordConverter::po2vo).collect(Collectors.toList());
        accountVo.setAccountRecords(accountRecordVos);
        return R.success(R.SUCCESS_MESSAGE_SELECT, accountVo);
    }

    @Log(businessModule = "账户模块", businessType = "PUT", businessDescribe = "账户充值")
    @ApiOperation("账户充值")
    @PutMapping
    public R updateAccountBalance(@Validated @RequestBody AccountRecordCreateDto accountRecordCreateDto) {
        boolean isSuccess = accountService.updateAccountBalance(accountRecordConverter.dto2po(accountRecordCreateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE) : R.fail(R.ERROR_MESSAGE);
    }
}
