package cn.itsource.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Date: 2019/12/27 18:00
 * @Author: yjz
 * @Version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class RedisServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisServiceApplication.class,args);
    }
}
