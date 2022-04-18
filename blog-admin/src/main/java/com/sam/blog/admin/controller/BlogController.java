package com.sam.blog.admin.controller;



import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.SystemContextUtils;
import com.sam.blog.component.dto.SArticleDto;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.service.SArticleService;
import com.sam.blog.component.util.CurrentUserNameUtil;
import com.sam.blog.component.vo.PageCommonVo;
import com.sam.blog.component.vo.SArticleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Api(value = "BlogController", description = "博客文章管理")
@RequestMapping(value = "/blog")
@RestController
public class BlogController {

    @Resource
    private SArticleService sArticleService;

    @GetMapping(value = "/role")
    @ApiOperation(value = "获取登录时间接口", notes = "获取登录时间接口")
    public ResponseResult getUserDemo(){
        return new ResponseResult(ResultCode.SUCCESS,sArticleService.getUserRoleFindOne());
    }

    @ApiOperation(value = "插入文章")
    @PostMapping(value = "/insert")
    public ResponseResult insertArticle(@RequestBody SArticleVo vo, HttpServletRequest request){
        SArticleDto sArticleDto = new SArticleDto();
        SystemContextUtils.copyBean(vo,  sArticleDto);
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }
        sArticleDto.setCreateUser(currentUserName);
        sArticleDto.setCreateTime(new Date());
        sArticleService.insertArticle(sArticleDto);
        return new ResponseResult(ResultCode.SUCCESS);
    }
    @ApiOperation(value = "更新文章")
    @PutMapping(value = "/update")
    public ResponseResult updateArticle(@RequestBody SArticleVo vo, HttpServletRequest request){
        SArticleDto sArticleDto = new SArticleDto();
        SystemContextUtils.copyBean(vo,  sArticleDto);
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }
        sArticleDto.setUpdateUser(currentUserName);
        sArticleDto.setUpdateTime(new Date());
        sArticleService.updateArticle(sArticleDto);
        return new ResponseResult(ResultCode.SUCCESS);
    }
    @ApiOperation(value = "获取文章信息")
    @GetMapping(value = "/getById")
    public ResponseResult getArticleById(@RequestParam("articleId") Integer articleId, HttpServletRequest request){
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }

        SArticleDto sArticleDto =sArticleService.getArticleById(articleId);
        return new ResponseResult(ResultCode.SUCCESS,sArticleDto);
    }

    @PostMapping(value = "/page")
    public ResponseResult getPageArticle(@RequestBody PageCommonVo vo, HttpServletRequest request){
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }
        Page<SArticle> pageArticle = sArticleService.getPageArticle(vo);
        return new ResponseResult(ResultCode.SUCCESS,pageArticle);
    }


}
