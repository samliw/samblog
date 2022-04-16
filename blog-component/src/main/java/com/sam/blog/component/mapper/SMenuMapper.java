package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SMenuMapper extends JpaRepository<SMenu,Integer>, JpaSpecificationExecutor<SMenu> {
}
