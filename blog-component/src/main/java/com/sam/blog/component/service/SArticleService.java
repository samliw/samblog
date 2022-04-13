package com.sam.blog.component.service;

import com.sam.blog.component.dto.SArticleDto;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SUserRole;

public interface SArticleService {
    SArticle getFindOne();

    SUserRole getUserRoleFindOne();

    void insertArticle(SArticleDto sArticleDto);

    void updateArticle(SArticleDto sArticleDto);

    SArticleDto getArticleById(Integer articleId);
}
