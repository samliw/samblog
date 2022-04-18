package com.sam.blog.admin.controller;

import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.SystemContextUtils;
import com.sam.blog.component.dto.SArticleDto;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SLink;
import com.sam.blog.component.service.SlinkService;
import com.sam.blog.component.util.CurrentUserNameUtil;
import com.sam.blog.component.vo.LinkVo;
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

@Api(value = "LinkController", description = "友情链接")
@RequestMapping(value = "/link")
@RestController
public class LinkController {
    @Resource
    private SlinkService slinkService;

    @ApiOperation(value = "添加链接")
    @PostMapping(value = "/insert")
    public ResponseResult insertArticle(@RequestBody LinkVo vo, HttpServletRequest request){
        SLink sLink = new SLink();
        SystemContextUtils.copyBean(vo,  sLink);
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }
        sLink.setCreatedUser(currentUserName);
        sLink.setCreatedTime(new Date());
        sLink.setLinkClick(0);
        SLink save = slinkService.save(sLink);
        return new ResponseResult(ResultCode.SUCCESS,save);
    }
    @ApiOperation(value = "更新链接信息")
    @PutMapping(value = "/update")
    public ResponseResult updateArticle(@RequestBody LinkVo vo, HttpServletRequest request){
        SLink sLink = new SLink();
        SystemContextUtils.copyBean(vo,  sLink);
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }
        sLink.setUpdatedUser(currentUserName);
        sLink.setUpdatedTime(new Date());
        SLink update = slinkService.update(sLink);
        return new ResponseResult(ResultCode.SUCCESS,update);
    }
    @ApiOperation(value = "获取链接信息")
    @GetMapping(value = "/getById")
    public ResponseResult getArticleById(@RequestParam("linkId") Integer linkId, HttpServletRequest request){
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }

        SLink linkById = slinkService.getLinkById(linkId);
        return new ResponseResult(ResultCode.SUCCESS,linkById);
    }

    @PostMapping(value = "/列表")
    public ResponseResult getPageArticle(@RequestBody PageCommonVo vo, HttpServletRequest request){
        String currentUserName = CurrentUserNameUtil.getCurrentUserName(request);
        if(StringUtils.isEmpty(currentUserName)){
            return new ResponseResult(ResultCode.FAIL);
        }
        Page<SLink> page = slinkService.getLinkPage(vo);
        return new ResponseResult(ResultCode.SUCCESS,page);
    }
}
