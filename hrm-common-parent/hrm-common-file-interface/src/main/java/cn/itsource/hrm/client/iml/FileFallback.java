package cn.itsource.hrm.client.iml;

import cn.itsource.hrm.client.FileClient;
import cn.itsource.hrm.util.AjaxResult;
import feign.Response;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: TODO
 * @Date: 2020/1/6 19:54
 * @Author: yjz
 * @Version:1.0
 */
public class FileFallback implements FileClient {
    @Override
    public Response downloadFile(String file_id) {
        return null;
    }

    @Override
    public AjaxResult feignUpload(MultipartFile file) {
        return null;
    }
}
