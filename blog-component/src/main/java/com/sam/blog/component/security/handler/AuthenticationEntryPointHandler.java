package com.sam.blog.component.security.handler;

import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户未登录处理类
 */
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    public static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationEntryPointHandler.class);
    /**
     * 用户未登录处理类 处理结果
     * @param httpServletRequest
     * @param httpServletResponse
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        e.printStackTrace();
        LOGGER.error("用户未登录处理类 处理结果：" + e.getMessage());
        ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.NOT_LOGIN));
    }
}
