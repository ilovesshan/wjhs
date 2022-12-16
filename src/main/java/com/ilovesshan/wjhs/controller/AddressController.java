package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.AddressConverter;
import com.ilovesshan.wjhs.beans.dto.AddressCreateDto;
import com.ilovesshan.wjhs.beans.dto.AddressUpdateDto;
import com.ilovesshan.wjhs.beans.pojo.Address;
import com.ilovesshan.wjhs.beans.vo.AddressVo;
import com.ilovesshan.wjhs.service.AddressService;
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
 * @date: 2022/12/15
 * @description:
 */

@Api(tags = "小程序地址模块")
@RestController
@RequestMapping("/wx/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressConverter addressConverter;

    @ApiOperation("根据ID查询地址")
    @GetMapping("/{id}")
    public R selectById(@PathVariable String id) {
        Address address = addressService.selectById(id);
        return R.success(R.SUCCESS_MESSAGE_SELECT, addressConverter.po2vo(address));
    }

    @ApiOperation("获取全部地址列表")
    @GetMapping()
    public R selectList() {
        List<Address> addresses = addressService.selectList();
        List<AddressVo> addressVos = addresses.stream().map(addressConverter::po2vo).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, addressVos);
    }

    @ApiOperation("根据ID删除地址")
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable String id) {
        boolean isSuccess = addressService.deleteById(id);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_DELETE) : R.fail(R.ERROR_MESSAGE_DELETE);
    }


    @ApiOperation("新增地址")
    @PostMapping()
    public R insert(@Validated @RequestBody AddressCreateDto addressCreateDto) {
        boolean isSuccess = addressService.insert(addressConverter.dto2po(addressCreateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_INSERT) : R.fail(R.ERROR_MESSAGE_INSERT);
    }


    @ApiOperation("更新地址")
    @PutMapping()
    public R update(@Validated @RequestBody AddressUpdateDto addressUpdateDto) {
        boolean isSuccess = addressService.update(addressConverter.dto2po(addressUpdateDto));
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_UPDATE) : R.fail(R.ERROR_MESSAGE_UPDATE);
    }
}
