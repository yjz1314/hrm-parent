package cn.itsource.hrm.client;

import cn.itsource.hrm.domain.Systemdictionaryitem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO
 * @Date: 2020/1/1 22:07
 * @Author: yjz
 * @Version:1.0
 */
@Component
@FeignClient(value = "SYSTEM-SERVICE",path = "/systemdictionaryitem")
public interface SystemDictionaryitemClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Systemdictionaryitem get(@PathVariable("id") Long id);
}
