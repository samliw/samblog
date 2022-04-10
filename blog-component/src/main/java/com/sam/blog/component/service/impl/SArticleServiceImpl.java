package com.sam.blog.component.service.impl;


import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SUserRole;
import com.sam.blog.component.mapper.SArticleMapper;
import com.sam.blog.component.mapper.SUserRoleMapper;
import com.sam.blog.component.service.SArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
