package com.sam.blog.common.config;

public class JWTConfig {

    /**
     * 秘钥
     */
    public static final String secret = "JWTSecret";

    /**
     * 请求头
     */
    public static final String tokenHeader = "Authorization";

    /**
     * token 前缀
     */
    public static final String tokenPrefix = "Beare";

    /**
     * 有效期
     */
    public static final long expiration = 86400;

    /**
     * 不需要验证访问路径
     */
    public static final String antMatchers = "/index/**,/login/**,/favicon.ico";
}
