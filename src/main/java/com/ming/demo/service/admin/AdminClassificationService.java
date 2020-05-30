package com.ming.demo.service.admin;

import com.github.pagehelper.PageHelper;
import com.ming.demo.mapper.admin.AdminClassificationMapper;
import com.ming.demo.model.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminClassificationService {
    @Autowired
    private AdminClassificationMapper adminClassificationMapper;

    public List<Classification> findAllClassIfication(int pageNo, int size){
        PageHelper.startPage(pageNo, size);
        return adminClassificationMapper.findAllClass();
    }

    public boolean insertClassIfication(Classification classification){
        if(adminClassificationMapper.insertClassIfication(classification) == 1){
            return true;
        }
        return  false;
    }

    public boolean deleteClassIfication(String id){
        if(adminClassificationMapper.deleteClassIfication(id) == 1){
            return true;
        }
        return false;
    }

    public boolean updateClassIfication(Classification classification){
        if(adminClassificationMapper.updateClassIfication(classification) == 1){
            return true;
        }
        return false;
    }
}
