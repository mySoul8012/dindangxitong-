package com.ming.demo.web;

import com.ming.demo.bean.ClassificationBean;
import com.ming.demo.mapper.ClassificationMapper;
import com.ming.demo.model.Classification;
import com.ming.demo.service.ClassificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 分类控制器
@RestController
@Deprecated
public class ClassificationController {
    @Autowired
    private ClassificationMapper classification1;

    @Autowired
    private ClassificationService classificationService;

    // 获取所有的
    @ApiOperation("获取所有的分类")
    @GetMapping("/getClassification")
    public List<ClassificationBean> findAll(){
        return classificationService.findAllClassificationBean();
    }
}
