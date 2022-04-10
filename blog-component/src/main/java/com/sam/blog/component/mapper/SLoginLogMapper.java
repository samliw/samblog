package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SLoginLogMapper extends JpaRepository<SLoginLog,Integer> {
}
