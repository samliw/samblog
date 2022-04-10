package com.sam.blog.component.jwt;

import com.alibaba.fastjson.JSON;
import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.component.security.entity.UserServiceDetail;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JWTUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(JWTUtil.class);

    public static String createJwtToken(UserServiceDetail serviceDetail){
        String tocken = Jwts.builder()
                // 放入用户名和用户ID
                .setId("" + serviceDetail.getUserId())
                // 主题
                .setSubject(serviceDetail.getUsername())
                // 签发时间
                .setIssuedAt(new Date())
                // 签发者
                .setIssuer("sam-blog-admin")
                // 自定义属性 放入用户拥有权限
                .claim("authorities", JSON.toJSONString(serviceDetail.getAuthorities()))
                // 失效时间
                .setExpiration(new Date(System.currentTimeMillis() + (JWTConfig.expiration * 1000)))
                // 签名算法和密钥
                .signWith(SignatureAlgorithm.HS512, JWTConfig.secret)
                .compact();
        return JWTConfig.tokenPrefix + tocken;
    }


}
