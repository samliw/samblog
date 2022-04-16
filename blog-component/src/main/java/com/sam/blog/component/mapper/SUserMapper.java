package com.sam.blog.component.mapper;

import com.sam.blog.component.entity.SUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface SUserMapper extends JpaRepository<SUser,Integer> , JpaSpecificationExecutor<SUser> {

    @Query("select t from SUser t where t.loginName = ?1 ")
    SUser findByUserName(String userName);
}
