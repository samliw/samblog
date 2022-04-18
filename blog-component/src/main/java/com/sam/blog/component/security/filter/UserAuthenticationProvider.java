package com.sam.blog.component.security.filter;


import com.sam.blog.common.constants.SystemConstants;
import com.sam.blog.common.constants.UserConstants;
import com.sam.blog.common.util.AccountRSAUtils;
import com.sam.blog.common.util.GetIP;
import com.sam.blog.component.entity.SLoginLog;
import com.sam.blog.component.security.entity.UserParamAuthenticationDetails;
import com.sam.blog.component.security.entity.UserServiceDetail;
import com.sam.blog.component.service.SUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
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

    public static final Logger LOGGER = LoggerFactory.getLogger(UserAuthenticationProvider.class);

    @Resource
    private SUserService sUserService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取用户登录参数信息
        UserParamAuthenticationDetails userParamAuthenticationDetails = (UserParamAuthenticationDetails) authentication.getDetails();
        SLoginLog sLoginLog = new SLoginLog();
        sLoginLog.setCreateTime(new Date());
        sLoginLog.setUserName(userParamAuthenticationDetails.getUsername());
        sLoginLog.setStatus(SystemConstants.LOGIN_STATUS_ERROR);
        if(userParamAuthenticationDetails == null){
            sLoginLog.setErrorDescribe("用户异常");
            sUserService.saveUserLogin(sLoginLog);
            throw new UsernameNotFoundException("用户异常");
        }
        // 查询用户是否存在
        UserServiceDetail userInfo = sUserService.getUserByUserName(userParamAuthenticationDetails.getUsername());
        if(StringUtils.isEmpty(userInfo.getUsername())  || StringUtils.isEmpty(userParamAuthenticationDetails.getUsername())|| !userParamAuthenticationDetails.getUsername().equals(userInfo.getUsername())){
            sLoginLog.setErrorDescribe("用户不存在");
            sUserService.saveUserLogin(sLoginLog);
            throw new UsernameNotFoundException("用户不存在");
        }
        // 我们还要判断密码是否正确，这里我们的密码使用BCryptPasswordEncoder进行加密的
        if(StringUtils.isEmpty(userInfo.getPassword()) || StringUtils.isEmpty(userParamAuthenticationDetails.getPassword())
                || !AccountRSAUtils.decode(userParamAuthenticationDetails.getPassword(),
                AccountRSAUtils.RSA_PRIVATE).equals(AccountRSAUtils.decode(userInfo.getPassword(),
                AccountRSAUtils.RSA_PRIVATE))){
            sLoginLog.setErrorDescribe("密码不正确");
            sUserService.saveUserLogin(sLoginLog);
            throw new BadCredentialsException("密码不正确");
        }
        // 还可以加一些其他信息的判断，比如用户账号已停用等判断
        if(StringUtils.isEmpty(userInfo.getStatus())  || userInfo.getStatus().equals(UserConstants.STATUS_PROHIBIT)){
            sUserService.saveUserLogin(sLoginLog);
            sLoginLog.setErrorDescribe("账号被锁");
            throw new LockedException("账号被锁");
        }
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
