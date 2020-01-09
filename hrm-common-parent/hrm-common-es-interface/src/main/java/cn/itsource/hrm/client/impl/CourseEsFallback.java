package cn.itsource.hrm.client.impl;

import cn.itsource.hrm.client.CourseEsClient;
import cn.itsource.hrm.document.CourseDocumentQuery;
import cn.itsource.hrm.document.CourseDoucment;
import cn.itsource.hrm.util.AjaxResult;
import cn.itsource.hrm.util.PageList;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: TODO
 * @Date: 2020/1/1 20:37
 * @Author: yjz
 * @Version:1.0
 */
@Component
public class CourseEsFallback implements CourseEsClient {
    @Override
    public AjaxResult createIndexes(List<CourseDoucment> courses) {
        return AjaxResult.me().setSuccess(false).setMessage("失败");
    }

    @Override
    public AjaxResult deleteIndexes(List<Long> ids) {
        return AjaxResult.me().setSuccess(false).setMessage("失败了");
    }

    @Override
    public PageList<CourseDoucment> searchIndexs(CourseDocumentQuery documentQuery) {
        return null;
    }
}
