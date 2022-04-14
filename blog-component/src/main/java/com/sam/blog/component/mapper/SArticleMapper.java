package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SArticleMapper extends JpaRepository<SArticle,Integer> , JpaSpecificationExecutor<SArticle> {
}
