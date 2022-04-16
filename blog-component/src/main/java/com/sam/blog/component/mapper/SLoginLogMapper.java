package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SLoginLogMapper extends JpaRepository<SLoginLog,Integer>, JpaSpecificationExecutor<SLoginLog> {
}
