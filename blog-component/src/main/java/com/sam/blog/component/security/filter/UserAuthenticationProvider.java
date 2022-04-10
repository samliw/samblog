package com.sam.blog.component.security.filter;


import com.sam.blog.component.security.entity.UserParamAuthenticationDetails;
import com.sam.blog.component.security.entity.UserServiceDetail;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * UsernameNotFoundException（用户不存在）
 * DisabledException（用户已被禁用）
 * BadCredentialsException（坏的凭据）
 * LockedException（账户锁定）
 * AccountExpiredException （账户过期）
 * CredentialsExpiredException（证书过期）
 * 自定义登录验证
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户登录参数信息
        UserParamAuthenticationDetails userParamAuthenticationDetails = (UserParamAuthenticationDetails) authentication.getDetails();
        // 查询用户是否存在
        UserServiceDetail userInfo = new UserServiceDetail(1L,"admin");
        if(StringUtils.isNotEmpty(userInfo.getUsername()) && !userParamAuthenticationDetails.getUsername().equals(userInfo.getUsername())){
            throw new UsernameNotFoundException("用户不存在");
        }
        // 我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if(StringUtils.isNotEmpty(userInfo.getPassword()) && !userParamAuthenticationDetails.getPassword().equals(userInfo.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        // 还可以加一些其他信息的判断，比如用户账号已停用等判断

        // 角色集合
        Set<GrantedAuthority> authorities = new HashSet<>();
        // 查询用户角色

        // 进行登录
        return new UsernamePasswordAuthenticationToken(userInfo, userParamAuthenticationDetails.getPassword(), authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
