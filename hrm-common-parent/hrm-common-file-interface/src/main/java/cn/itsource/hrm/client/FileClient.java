package cn.itsource.hrm.client;

import cn.itsource.hrm.client.iml.FileFallback;
import cn.itsource.hrm.util.AjaxResult;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: TODO
 * @Date: 2020/1/6 19:49
 * @Author: yjz
 * @Version:1.0
 */
@Component
@FeignClient(value = "FILE-SERVICE",path = "/fastdfs",fallback = FileFallback.class)
public interface FileClient {

    @RequestMapping(value = "/downloadFile",method = RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Response downloadFile(@RequestParam("fileId")String file_id);

    @RequestMapping(value = "/feignUpload",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    AjaxResult feignUpload(@RequestPart(value = "file")MultipartFile file);



}
