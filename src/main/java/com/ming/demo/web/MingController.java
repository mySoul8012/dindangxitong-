package com.ming.demo.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api("测试")
public class MingController {
    @RequestMapping("/index")
    @ApiOperation("index")
    public String ming(){
        return "index";
    }
}
