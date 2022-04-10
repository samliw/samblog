package com.sam.blog.component.security.handler;

import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销登录
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserLogoutSuccessHandler.class);
    /**
     * 注销登录返回
     * @param httpServletRequest
     * @param httpServletResponse
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        LOGGER.error("注销登录返回");
        ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.SUCCESS));
    }
}
