package com.sam.blog.component.security;

import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.component.security.filter.JWTAuthenticationTokenFilter;
import com.sam.blog.component.security.filter.UserAuthenticationDetailsSource;
import com.sam.blog.component.security.filter.UserAuthenticationProvider;
import com.sam.blog.component.security.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import javax.annotation.Resource;

/**
 * SpringSecurity核心配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 开启注解权限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置未登录的处理类
     */
    @Resource
    private AuthenticationEntryPointHandler authenticationEntryPointHandler;
    @Resource
    private UserLoginSuccessHandler userLoginSuccessHandler;
    @Resource
    private UserLoginFailureHandler userLoginFailureHandler;
    @Resource
    private UserLogoutSuccessHandler userLogoutSuccessHandler;
    @Resource
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;

    /**
     * 自定义登录逻辑验证器
     */
    @Resource
    private UserAuthenticationProvider userAuthenticationProvider;
    /**
     *  配置登录验证逻辑
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(userAuthenticationProvider);
    }

    /**
     * 自定义参数认证
     */
    @Resource
    private UserAuthenticationDetailsSource userAuthenticationDetailsSource;

    /**
     * 配置security 的控制逻辑
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 配置不进行权限登录就可以访问的连接
                .antMatchers(JWTConfig.antMatchers.split(",")).permitAll().antMatchers("/swagger-ui.html","/statics/**","/webjars/**").anonymous()
                // 配置其他路径都需要登录才可以访问
                .anyRequest().authenticated()
                .and()
                // 配置未登录定义的处理类
                .httpBasic().authenticationEntryPoint(authenticationEntryPointHandler)
                .and()
                // 配置登录地址
                .formLogin()
                .loginProcessingUrl("/login/userLogin")
                // 配置登录成功处理类
                .successHandler(userLoginSuccessHandler)
                // 配置登录失败处理类
                .failureHandler(userLoginFailureHandler)
                // 自定义参数认证逻辑
                .authenticationDetailsSource(userAuthenticationDetailsSource)
                .and()
                // 配置推出登录地址
                .logout()
                .logoutUrl("/login/userLogout")
                .logoutSuccessHandler(userLogoutSuccessHandler)
                .and()
                // 配置没有权限处理类
                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                .and()
                // 配置跨域
                .cors()
                .and()
                // 取消跨站请求伪造保护
                .csrf().disable();
        // 基于token 不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT 过滤验证
        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger/**")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/v2/api-docs-ext/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/doc.html");
    }
}
