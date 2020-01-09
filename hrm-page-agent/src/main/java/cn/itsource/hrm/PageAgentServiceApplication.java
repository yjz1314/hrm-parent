package cn.itsource.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description: TODO
 * @Date: 2020/1/7 17:17
 * @Author: yjz
 * @Version:1.0
 */
@SpringBootApplication
@EnableFeignClients
public class PageAgentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PageAgentServiceApplication.class, args);
    }

}