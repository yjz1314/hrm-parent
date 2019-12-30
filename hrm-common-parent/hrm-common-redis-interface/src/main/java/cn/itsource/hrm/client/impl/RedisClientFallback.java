package cn.itsource.hrm.client.impl;

import cn.itsource.hrm.client.RedisClient;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Date: 2019/12/27 18:49
 * @Author: yjz
 * @Version 1.0
 **/
@Component
public class RedisClientFallback implements RedisClient {

    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key) {
        return "获取失败！请稍后再试!";
    }
}
