package cn.itsource.hrm.client;

import cn.itsource.hrm.client.impl.PageInfoFallback;
import cn.itsource.hrm.domain.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: TODO
 * @Date: 2020/1/6 19:44
 * @Author: yjz
 * @Version:1.0
 */
@FeignClient(value = "PAGE-SERVICE",fallback = PageInfoFallback.class)
public interface PageInfoClient {

    /**
     * 根据id查询pageInfo
     * @param id
     * @return
     */
    @RequestMapping(value = "/pageInfo/{id}",method = RequestMethod.GET)
    PageInfo get(@PathVariable("id")Long id);


}
