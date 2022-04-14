package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SArticleTypeMapper extends JpaRepository<SArticleType,Integer>, JpaSpecificationExecutor<SArticleType> {
}
