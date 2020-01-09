package cn.itsource.hrm.client;

import cn.itsource.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: TODO
 * @Date: 2020/1/5 23:48
 * @Author: yjz
 * @Version:1.0
 */
@FeignClient(value = "STATIC-SERVICE")
public interface PageClient {

    /**
     * 页面静态化接口
     * @param dataKey
     * @param pageId
     * @return
     */
    @PostMapping("/staticPage")
    AjaxResult staticPage(@RequestParam("dataKey") String dataKey, @RequestParam("pageId")Long pageId);

}
