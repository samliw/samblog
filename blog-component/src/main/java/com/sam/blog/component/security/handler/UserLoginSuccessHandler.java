package com.sam.blog.component.security.handler;

import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.common.constants.SystemConstants;
import com.sam.blog.common.exception.ResponseResult;
import com.sam.blog.common.exceptionenum.ResultCode;
import com.sam.blog.common.util.GetIP;
import com.sam.blog.component.dto.SUserDto;
import com.sam.blog.component.entity.SLoginLog;
import com.sam.blog.component.security.entity.UserServiceDetail;
import com.sam.blog.component.jwt.JWTUtil;
import com.sam.blog.component.service.SUserService;
import com.sam.blog.component.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 登录成功
 */
@Component
public class UserLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserLoginSuccessHandler.class);
    @Resource
    private SUserService sUserService;
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
        LOGGER.info("返回结果");
        UserServiceDetail userServiceDetail = (UserServiceDetail) authentication.getPrincipal();
        // 本地线程变量
        UserThreadLocal.setUser(new SUserDto(userServiceDetail.getUserId(),userServiceDetail.getUsername()));
        String jwtToken = JWTUtil.createJwtToken(userServiceDetail);
        jwtToken = JWTConfig.tokenPrefix + jwtToken;
        // 保存登录日志
        SLoginLog sLoginLog = new SLoginLog();
        sLoginLog.setIpAddress(GetIP.getIpAddress(httpServletRequest));
        sLoginLog.setCreateTime(new Date());
        sLoginLog.setUserId(userServiceDetail.getUserId());
        sLoginLog.setStatus(SystemConstants.LOGIN_STATUS_SUCCESS);
        sLoginLog.setUserName(userServiceDetail.getUsername());
        sUserService.saveUserLogin(sLoginLog);
        ResponseResult.responseJson(httpServletResponse,new ResponseResult(ResultCode.SUCCESS,jwtToken));
    }
}
