package com.ming.demo.web;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "测试")
public class MingController {
    @GetMapping("/index")
    @ApiOperation("index")
    public String ming(){
        return "index";
    }
}
