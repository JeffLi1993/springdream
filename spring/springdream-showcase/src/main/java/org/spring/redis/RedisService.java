package org.spring.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by bysocket on 16/3/28.
 */
@Component
public class RedisService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisService.class);

    private RedisTemplate redisTemplate;
    private long cacheTTL;

    public String getValue(String key) {
        ValueOperations<String,String> kv = redisTemplate.opsForValue();
        return kv.get(key);
    }

    public void setValue(String key,String value) {
        ValueOperations<String,String> kv = redisTemplate.opsForValue();
        kv.set(key,value);
    }

    public void setValueWithTTL(String key,String value) {
        ValueOperations<String,String> kv = redisTemplate.opsForValue();
        redisTemplate.expire(key,cacheTTL, TimeUnit.SECONDS);
        kv.set(key,value);
    }

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setCacheTTL(long cacheTTL) {
        this.cacheTTL = cacheTTL;
    }
}
