package com.sam.blog.component.service.impl;


import com.sam.blog.common.exception.BusinessException;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.SystemContextUtils;
import com.sam.blog.component.dto.SArticleDto;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SUserRole;
import com.sam.blog.component.mapper.SArticleMapper;
import com.sam.blog.component.mapper.SUserRoleMapper;
import com.sam.blog.component.service.SArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SArticleServiceImpl implements SArticleService {

    @Resource
    private SArticleMapper sArticleMapper;
    @Resource
    private SUserRoleMapper sUserRoleMapper;
    @Override
    public SArticle getFindOne() {
        return sArticleMapper.getOne(1);
    }

    @Override
    public SUserRole getUserRoleFindOne() {
        return sUserRoleMapper.getOne(1);
    }

    @Transactional
    @Override
    public void insertArticle(SArticleDto sArticleDto) {
        if(StringUtils.isEmpty(sArticleDto.getArticleName())){
            throw new BusinessException(ResultCode.INCOMPLETE_PARAM);
        }
        SArticle sArticle = new SArticle();
        SystemContextUtils.copyBean(sArticleDto,  sArticle);
        sArticleMapper.save(sArticle);
    }

    @Transactional
    @Override
    public void updateArticle(SArticleDto sArticleDto) {
        if(StringUtils.isEmpty(sArticleDto.getArticleName())){
            throw new BusinessException(ResultCode.INCOMPLETE_PARAM);
        }
        SArticle sArticle = sArticleMapper.getOne(sArticleDto.getArticleId());
        SystemContextUtils.copyBean(sArticleDto,  sArticle);
        sArticleMapper.save(sArticle);
    }

    @Override
    public SArticleDto getArticleById(Integer articleId) {
        SArticleDto sArticleDto = new SArticleDto();
        SArticle sArticle = sArticleMapper.getOne(articleId);
        SystemContextUtils.copyBean(sArticle,  sArticleDto);
        return sArticleDto;
    }
}
