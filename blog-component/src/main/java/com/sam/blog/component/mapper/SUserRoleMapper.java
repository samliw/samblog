package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SUserRoleMapper extends JpaRepository<SUserRole,Integer>, JpaSpecificationExecutor<SUserRole> {
}
