package cn.itsource.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: TODO
 * @Date: 2020/1/6 00:07
 * @Author: yjz
 * @Version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class StaticPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaticPageApplication.class, args);
    }

}