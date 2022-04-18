package com.sam.blog.component.service.impl;

import com.sam.blog.component.entity.SLoginLog;
import com.sam.blog.component.entity.SUser;
import com.sam.blog.component.mapper.SLoginLogMapper;
import com.sam.blog.component.mapper.SUserMapper;
import com.sam.blog.component.security.entity.UserServiceDetail;
import com.sam.blog.component.service.SUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SUserServiceImpl implements SUserService {

    @Resource
    private SUserMapper sUserMapper;
    @Resource
    private SLoginLogMapper sLoginLogMapper;

    @Override
    public UserServiceDetail getUserByUserName(String userName) {
        UserServiceDetail userServiceDetail = new UserServiceDetail();
        SUser byUserName = sUserMapper.findByUserName(userName);
        if(byUserName == null){
            return userServiceDetail;
        }
        userServiceDetail.setUserId(byUserName.getUserId());
        userServiceDetail.setUsername(byUserName.getLoginName());
        userServiceDetail.setPassword(byUserName.getUserPassword());
        /**
         * 状态:NORMAL正常  PROHIBIT禁用
         */
        String status = "NORMAL";
        if(byUserName.getUserStatus() == 1){
            status = "PROHIBIT";
        }
        userServiceDetail.setStatus(status);
        return userServiceDetail;
    }

    @Transactional
    @Override
    public void saveUserLogin(SLoginLog sLoginLog) {
        sLoginLogMapper.save(sLoginLog);
    }


}
