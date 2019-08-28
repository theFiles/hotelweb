package com.fourseasons.hotel.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

// 让测试运行于Spring测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 引入配置文件
@ContextConfiguration("classpath:spring-mvc.xml")
public class TokenTest {

    @Test
    public void enToken() {
        System.out.println(Token.enToken(1, 124432543L));
    }

    @Test
    public void deToken() {
    }
}