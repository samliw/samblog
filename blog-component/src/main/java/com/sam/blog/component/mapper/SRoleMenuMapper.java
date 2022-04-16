package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SRoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SRoleMenuMapper extends JpaRepository<SRoleMenu,Integer>, JpaSpecificationExecutor<SRoleMenu> {
}
