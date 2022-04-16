package com.sam.blog.component.service;

import com.sam.blog.component.dto.SArticleDto;
import com.sam.blog.component.entity.SArticle;
import com.sam.blog.component.entity.SUserRole;
import org.springframework.data.domain.Page;

public interface SArticleService {
    SArticle getFindOne();

    Page<SArticle> getUserRoleFindOne();

    void insertArticle(SArticleDto sArticleDto);

    void updateArticle(SArticleDto sArticleDto);

    SArticleDto getArticleById(Integer articleId);
}
