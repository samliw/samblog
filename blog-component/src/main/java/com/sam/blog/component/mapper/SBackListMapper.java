package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SBackList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SBackListMapper extends JpaRepository<SBackList, Integer>, JpaSpecificationExecutor<SBackList> {
}
