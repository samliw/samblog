package com.sam.blog.component.security.handler;

import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.component.security.entity.UserServiceDetail;
import com.sam.blog.component.jwt.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功
 */
@Component
public class UserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserLoginSuccessHandler.class);
    /**
     * 返回结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        LOGGER.error("返回结果");
        UserServiceDetail userServiceDetail = (UserServiceDetail) authentication.getPrincipal();
        String jwtToken = JWTUtil.createJwtToken(userServiceDetail);
        jwtToken = JWTConfig.tokenPrefix + jwtToken;
        ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.SUCCESS,jwtToken));
    }
}
