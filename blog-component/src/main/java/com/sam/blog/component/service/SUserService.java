package com.sam.blog.component.service;

import com.sam.blog.component.security.entity.UserServiceDetail;

public interface SUserService {

    /**
     * 通过usee name 获取用户登录信息
     * @param userName
     * @return
     */
    UserServiceDetail getUserByUserName(String userName);

}
