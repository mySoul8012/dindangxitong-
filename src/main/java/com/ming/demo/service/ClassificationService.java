package com.ming.demo.service;

import com.ming.demo.bean.ClassificationBean;
import com.ming.demo.mapper.ClassificationMapper;
import com.ming.demo.model.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificationService {
    @Autowired
    private ClassificationMapper classificationMapper;

    public List<ClassificationBean> findAllClassificationBean(){
        // 获取所有的结果
        List<Classification> classificationList = classificationMapper.findAll();
        List<ClassificationBean> classificationBeans = new ArrayList<>();
        /// 进行转化
        for (Classification classification : classificationList) {
            // 进行转化
            ClassificationBean classificationBean = new ClassificationBean();
            // 进行添加
            classificationBean.setId(classification.getId());
            classificationBean.setImgUrl(classification.getImgUrl());
            classificationBean.setName(classification.getName());
            classificationBean.setNotes(classification.getNotes());
            classificationBean.setStatus(classification.getStatus());
            // 创建日期转化
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            // 进行日期转化
            String date = simpleDateFormat.format(classification.getCreationDate());
            // 添加进入日期
            classificationBean.setCreationDate(date);
            // 添加进入
            classificationBeans.add(classificationBean);
        }
        // 返回结果
        return classificationBeans;
    }
}
