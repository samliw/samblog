package com.sam.blog.admin;

import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.common.util.AccountRSAUtils;
import com.sam.blog.component.security.entity.UserServiceDetail;
import com.sam.blog.component.jwt.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void testDemo(){
        System.out.println(JWTConfig.secret);
        System.out.println(JWTUtil.createJwtToken(new UserServiceDetail(1,"shda")));
    }
    @Test
    public void testPasswordDecrypt() {
        String password = "lwh123456!!";
        /**
         * 获取公钥 和私钥
         */
        Map<String, String> rsaKeys = AccountRSAUtils.createRSAKeys();
        // 公钥
        String aPublic = rsaKeys.get(AccountRSAUtils.PUBLIC_KEY_NAME);
        // 私钥
        String aPrivate = rsaKeys.get(AccountRSAUtils.PRIVATE_KEY_NAME);
        // 加密
        String encode = AccountRSAUtils.encode(password, aPublic);
        // 解密
        String decode = AccountRSAUtils.decode("lOVjxhfmKB4v4j7ROuQoB4+mp4Hi3aa9p0Ts+zhT+oZ7L5BlZustjOqCZeFd/ST9lfTWNJ0nmvGOvNzWCQV9LtN5IOZFIcdsh1uIgtTf8Vv4QvxNQthSZOXE+wzC8qhqLrBhNxqrQAqnacOlwvdbVVHuW/VCBaVepHyPgP+Tjbc=", aPrivate);
        System.out.println( "公钥 : " + aPublic);
        System.out.println( "私钥 : " + aPrivate);
        System.out.println( "加密 : " + encode);
        System.out.println( "解密 : " + decode);
    }
}
