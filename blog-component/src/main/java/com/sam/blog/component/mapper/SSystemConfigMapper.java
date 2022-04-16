package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SSystemConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SSystemConfigMapper extends JpaRepository<SSystemConfig,Integer>, JpaSpecificationExecutor<SSystemConfig> {
}
