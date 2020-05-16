package com.ming.demo.web.search;

import com.ming.demo.model.Goods;
import com.ming.demo.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SeasrchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/searchList")
    public List<Goods> searchList(String keyWorld){
        return searchService.searchKeyWorldList(keyWorld);
    }
}
