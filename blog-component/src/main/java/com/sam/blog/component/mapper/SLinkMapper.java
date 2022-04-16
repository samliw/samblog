package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SLinkMapper extends JpaRepository<SLink,Integer>, JpaSpecificationExecutor<SLink> {
}
