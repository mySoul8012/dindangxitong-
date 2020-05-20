package com.ming.demo.web.evaluation;

import com.ming.demo.bean.evaluation.EvaluationCountBean;
import com.ming.demo.bean.evaluation.EvaluationListBean;
import com.ming.demo.service.evaluation.EvaluationServiceEvaluation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 评价控制器
@RestController
@RequestMapping("/evaluation")
@Api(tags = "评价控制器")
public class EvaluationController {

    @Autowired
    private EvaluationServiceEvaluation evaluationServiceEvaluation;


    // 数量
    @ApiOperation("评论数量")
    @RequestMapping("/evaluationCount")
    public EvaluationCountBean evaluationCount(String id){
        return evaluationServiceEvaluation.evaluationCountBean(id);
    }

    // 分类  sort
    // 全部 1
    // 好评 3
    // 中评 4
    // 差评 5
    // 是否 有图
    // 页数 pageNo
    // isImg 如果等于0，直接不筛选
    // 页面条数 size
    // PageNo 第几页
    @RequestMapping("/evaluationList")
    @ApiOperation("评论列表")
    public List<EvaluationListBean> evaluationList(String id,
                                                   @RequestParam(defaultValue = "1")String sort,
                                                   @RequestParam(defaultValue = "0")String isImg,
                                                   @RequestParam(defaultValue = "0")int pageNo,
                                                   @RequestParam(defaultValue = "5")int size){
        return evaluationServiceEvaluation.evaluationListBean(id, sort, isImg, pageNo, size);
    }
}
