package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SSystemNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SSystemNoticeMapper extends JpaRepository<SSystemNotice,Integer> , JpaSpecificationExecutor<SSystemNotice> {
}
