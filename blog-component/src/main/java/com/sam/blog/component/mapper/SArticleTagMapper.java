package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SArticleTagMapper extends JpaRepository<SArticleTag, Integer> {
}
