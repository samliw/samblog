package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SArticleTypeMapper extends JpaRepository<SArticleType,Integer> {
}
