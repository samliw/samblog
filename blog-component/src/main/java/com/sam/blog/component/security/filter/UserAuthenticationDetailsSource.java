package com.sam.blog.component.security.filter;

import com.sam.blog.component.security.entity.UserParamAuthenticationDetails;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 取出登录参数赋值给User Param
 */
@Component
public class UserAuthenticationDetailsSource implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> {
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest context) {
        return new UserParamAuthenticationDetails(context);
    }
}
