package cn.itsource.hrm.client;

import cn.itsource.hrm.client.impl.CourseEsFallback;
import cn.itsource.hrm.document.CourseDoucment;
import cn.itsource.hrm.util.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Description: TODO
 * @Date: 2020/1/1 20:36
 * @Author: yjz
 * @Version:1.0
 */
@FeignClient(value = "ES-SERVICE",path = "/es",fallback = CourseEsFallback.class)
public interface CourseEsClient {
    @PostMapping("/create")
    AjaxResult createIndexes(@RequestBody List<CourseDoucment> courses);
    /**
     * 删除索引
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    AjaxResult deleteIndexes(@RequestBody List<Long> ids);
}
