package cn.itsource.hrm.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: TODO
 * @Date: 2019/12/26 09:37
 * @Author: yjz
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "hrm.swagger")
public class SwaggerProperties {
    private String basePackage = "cn.itsource.hrm.web.controller";
    private String title;
    private String description;
    private String name = "yjz";
    private String url = "";
    private String email = "961259149@qq.com";
    private String version = "1.0";
}
