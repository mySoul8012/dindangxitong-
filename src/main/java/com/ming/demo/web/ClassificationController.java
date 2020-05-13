package com.ming.demo.web;

import com.ming.demo.mapper.ClassificationMapper;
import com.ming.demo.model.Classification;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 分类控制器
@Api("分类控制器")
@RestController
public class ClassificationController {
    @Autowired
    private ClassificationMapper classification1;

    // 获取所有的
    @ApiOperation("获取所有的分类")
    @RequestMapping("/getClassification")
    public List<Classification> findAll(){
        // 从mapper中获取
        return classification1.findAll();
    }
}
