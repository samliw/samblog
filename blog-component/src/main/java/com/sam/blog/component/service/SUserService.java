package com.sam.blog.component.service;

import com.sam.blog.component.entity.SLoginLog;
import com.sam.blog.component.security.entity.UserServiceDetail;

public interface SUserService {

    /**
     * 通过usee name 获取用户登录信息
     * @param userName
     * @return
     */
    UserServiceDetail getUserByUserName(String userName);

    /**
     * 保存登录日志
     * @param sLoginLog
     */
    void saveUserLogin(SLoginLog sLoginLog);

}
