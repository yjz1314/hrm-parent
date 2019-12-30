package cn.itsource.hrm.client;

import cn.itsource.hrm.client.impl.RedisClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: TODO
 * @Date: 2019/12/27 18:47
 * @Author: yjz
 * @Version 1.0
 **/
@FeignClient(value = "REDIS-GATEWAY", path = "/redis", fallback = RedisClientFallback.class)
public interface RedisClient {
    /**
     * 设置值
     * @param key
     * @param value
     */
    @PostMapping("/set")
    public void set(@RequestParam("key") String key, @RequestParam("value") String value);

    /**
     * 获取值
     * @param key
     * @return
     */
    @GetMapping("/get")
    public String get(@RequestParam("key") String key);
}
