package com.ming.demo.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MingController {
    @RequestMapping("/index")
    public String ming(){
        return "index";
    }
}
