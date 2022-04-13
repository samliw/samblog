package com.sam.blog.component.util;

import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.component.dto.SUserDto;
import com.sam.blog.component.jwt.JWTUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取当前登录用户名
 */
public class CurrentUserNameUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserNameUtil.class);
    private static ThreadLocal<SUserDto> userHolder = new ThreadLocal<SUserDto>();
    public static String getCurrentUserName(HttpServletRequest request){
        SUserDto sUserDto = userHolder.get();
        if(sUserDto != null){
            return sUserDto.getLoginName();
        }
        String token = request.getHeader(JWTConfig.tokenHeader);
        String userName = null;
        if (null != token && token.startsWith(JWTConfig.tokenPrefix)) {
            try {
                Claims claims = JWTUtil.parseToken(token);
                userName = claims.getSubject();
            }catch (Exception e){
                LOGGER.error("获取当前登录用户失败，失败原因",e.getMessage());
                e.printStackTrace();
            }
        }
        return userName;
    }
}
