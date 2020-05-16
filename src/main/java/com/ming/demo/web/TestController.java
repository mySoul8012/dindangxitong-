package com.ming.demo.web;

import com.ming.demo.bean.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/mingming")
    public Result result(){
        return new Result();
    }
}
