package org.jeff.spring.service;

import junit.framework.TestCase;
import org.jeff.spring.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by BYSocket on 2015/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)//基于JUINT4的Spring测试框架
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//启动Spring容器
public class TestUserService extends TestCase {

    @Autowired
    private UserService userService;

    @Test
    public void hasMatchUser(){
//        boolean b1 = userService.hasMatchCount("123","123");
//        assertTrue(b1);
    }

    @Test
    public void test(){
        User user = userService.findUserByUserName("jeff");
        System.out.println(user.getEmail());
    }
}