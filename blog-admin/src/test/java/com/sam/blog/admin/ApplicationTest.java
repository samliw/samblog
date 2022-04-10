package com.sam.blog.admin;

import com.sam.blog.common.config.JWTConfig;
import com.sam.blog.component.security.entity.UserServiceDetail;
import com.sam.blog.component.jwt.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Test
    public void testDemo(){
        System.out.println(JWTConfig.secret);
        System.out.println(JWTUtil.createJwtToken(new UserServiceDetail(1L,"shda")));
    }
}
