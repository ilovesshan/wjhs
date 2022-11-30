package com.ilovesshan.wjhs.controller;

import com.ilovesshan.wjhs.beans.converter.SystemDictConverter;
import com.ilovesshan.wjhs.beans.pojo.SystemDict;
import com.ilovesshan.wjhs.beans.vo.SystemDictVo;
import com.ilovesshan.wjhs.service.SystemDictService;
import com.ilovesshan.wjhs.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@RestController
@RequestMapping("/systemDict")
public class SystemDictController {

    @Autowired
    private SystemDictService systemDictService;


    @Autowired
    private SystemDictConverter systemDictConverter;

    @GetMapping
    public R selectAll() {
        List<SystemDict> systemDicts = systemDictService.selectAll();
        List<SystemDictVo> systemDictVos = systemDicts.stream().map(systemDict -> systemDictConverter.po2vo(systemDict)).collect(Collectors.toList());
        return R.success(R.SUCCESS_MESSAGE_SELECT, systemDictVos);
    }
}
