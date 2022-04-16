package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SArticleTagMapper extends JpaRepository<SArticleTag, Integer>, JpaSpecificationExecutor<SArticleTag> {
}
