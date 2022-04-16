package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SRoleMapper extends JpaRepository<SRole,Integer> , JpaSpecificationExecutor<SRole> {
}
