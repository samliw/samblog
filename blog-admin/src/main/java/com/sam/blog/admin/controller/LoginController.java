package com.sam.blog.admin.controller;

import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.AccountRSAUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登录接口")
@RequestMapping(value = "/login")
@RestController
public class LoginController {

    @ApiOperation(value = "获取登录密码加密公钥")
    @GetMapping(value = "/getPasswordPublicKey")
    public ResponseResult getPasswordPublicKey(){
        return new ResponseResult(ResultCode.SUCCESS, AccountRSAUtils.createRSAKeys().get(AccountRSAUtils.PUBLIC_KEY_NAME).toString());
    }
}
