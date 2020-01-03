package cn.itsource.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Date: 2020/1/1 20:05
 * @Author: yjz
 * @Version:1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class EsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EsServiceApplication.class,args);
    }
}
