package org.spring.spring.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.spring.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)//基于JUINT4的Spring测试框架
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})//启动Spring容器
public class TestRedisService extends TestCase {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestRedisService.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void setGetValue(){
        String key = "user";
        String value = "bysocket";
        redisService.setValue(key,value);
        System.out.println(redisService.getValue(key));
    }

    @Test
    public void setValueWhitTTL(){
        String key = "user1";
        String value = "bysocket1";
        redisService.setValueWithTTL(key,value);
        System.out.println(redisService.getValue(key));
        try {
            TimeUnit.SECONDS.sleep(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(redisService.getValue(key));
    }
}