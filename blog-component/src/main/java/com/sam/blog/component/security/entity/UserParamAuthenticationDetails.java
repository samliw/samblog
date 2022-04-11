package com.sam.blog.component.security.entity;

import com.alibaba.fastjson.JSONObject;
import com.sam.blog.common.util.RequestBodyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义登录传入参数
 */
public class UserParamAuthenticationDetails extends WebAuthenticationDetails {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserParamAuthenticationDetails.class);
    private static final long serialVersionUID = 6975601077710753878L;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 验证码
     */
    private Integer code;

    private String publicKey;
    public UserParamAuthenticationDetails(HttpServletRequest request) {
        super(request);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = JSONObject.parseObject(RequestBodyUtil.getRequestPostStr(request));
        } catch (IOException e) {
            LOGGER.error("获取登录参数异常", e.getMessage());
            e.printStackTrace();
        }
        username = jsonObject.getString("username");
        password = jsonObject.getString("password");
        code = Integer.valueOf(jsonObject.getString("code"));
        publicKey = jsonObject.getString("publicKey");

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
