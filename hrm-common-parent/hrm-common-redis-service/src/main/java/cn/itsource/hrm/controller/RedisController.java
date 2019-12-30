package cn.itsource.hrm.controller;

import cn.itsource.hrm.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Date: 2019/12/27 18:17
 * @Author: yjz
 * @Version 1.0
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 设置值
     * @param key
     * @param value
     */
    @PostMapping("/set")
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    /**
     * 获取值
     * @param key
     * @return
     */
    @GetMapping("/get")
    public String get(String key) {
        return redisUtils.get(key);
    }
}
