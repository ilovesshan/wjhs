package com.ilovesshan.wjhs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/24
 * @description:
 */

@Api(tags = "首页")
@Controller
@RequestMapping
public class IndexController {

    @GetMapping
    @ResponseBody
    @ApiOperation("index")
    public String index() {
        return "欢迎访问wjhs项目接口API文档,详细地址: http://localhost/doc.html";
    }
}
