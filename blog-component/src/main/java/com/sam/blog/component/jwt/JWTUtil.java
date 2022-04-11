package com.sam.blog.component.jwt;

import com.alibaba.fastjson.JSON;
import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.component.security.entity.UserServiceDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * JWT 工具类
 */
public class JWTUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(JWTUtil.class);

    /***
     * 生成 token
     * @param serviceDetail
     * @return
     */
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

    /**
     * 解析token
     * @param headerToken
     * @return
     */
    public static Claims parseToken(String headerToken){
        String token = headerToken.replace(JWTConfig.tokenPrefix, "");
        return Jwts.parser()
                .setSigningKey(JWTConfig.secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 判断JWT 有没有过期
     * @param jws
     * @return TRUE 过期  FALSE 未过期
     */
    public static Boolean isTokenExpired(Jws<Claims> jws){
        return jws.getBody().getExpiration().before(new Date());
    }

}
