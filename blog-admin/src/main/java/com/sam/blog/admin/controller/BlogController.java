package com.sam.blog.admin.controller;



import com.sam.blog.common.exception.BusinessException;
import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SUserRole;
import com.sam.blog.component.service.SArticleService;
import org.hibernate.criterion.NullExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping(value = "/blog")
@RestController
public class BlogController {

    @Resource
    private SArticleService sArticleService;

    @GetMapping(value = "/demo")
    public SArticle getDemo(){
        return sArticleService.getFindOne();
    }
    @GetMapping(value = "/role")
    public ResponseResult getUserDemo(){
        int i = 1/0;
        return new ResponseResult(ResultCode.SUCCESS,sArticleService.getUserRoleFindOne());
    }
    @PostMapping("/hello")
    public boolean insert(Integer i) {
        System.out.println("开始...");
        //如果姓名为空就手动抛出一个自定义的异常！
        if(i==null){
            throw  new BusinessException(Boolean.FALSE,-1 ,"i不能为空！");
        }
        return true;
    }

    @PutMapping("/hello")
    public boolean update() {
        System.out.println("开始更新...");
        //这里故意造成一个空指针的异常，并且不进行处理
        String str=null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/hello")
    public boolean delete()  {
        System.out.println("开始删除...");
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }

}
