package com.sam.blog.component.security.handler;

import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败
 */
@Component
public class UserLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserLoginFailureHandler.class);
    /**
     * 登录失败处理结果
     * UsernameNotFoundException（用户不存在）
     * DisabledException（用户已被禁用）
     * BadCredentialsException（坏的凭据）
     * LockedException（账户锁定）
     * AccountExpiredException （账户过期）
     * CredentialsExpiredException（证书过期）
     * @param httpServletRequest
     * @param httpServletResponse
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException exception) throws IOException, ServletException {

        if(exception instanceof UsernameNotFoundException){
            LOGGER.error("用户名不正确",exception.getMessage());
            ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.NOT_USER_NAME_EXIST));
        }
        if(exception instanceof LockedException){
            LOGGER.error("账号被锁",exception.getMessage());
            ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.USER_LOCK));
        }
        if(exception instanceof BadCredentialsException){
            LOGGER.error("密码不正确",exception.getMessage());
            ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.PASSWORD_ERROR));
        }
        ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.LOGIN_ERROR));
    }
}
