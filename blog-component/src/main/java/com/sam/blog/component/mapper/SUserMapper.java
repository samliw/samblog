package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SUserMapper extends JpaRepository<SUser,Integer> {
}
