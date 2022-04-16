package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.STag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface STagMapper extends JpaRepository<STag,Integer>, JpaSpecificationExecutor<STag> {
}
