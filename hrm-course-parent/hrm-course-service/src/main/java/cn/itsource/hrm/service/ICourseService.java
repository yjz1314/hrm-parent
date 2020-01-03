package cn.itsource.hrm.service;

import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjz
 * @since 2019-12-31
 */
public interface ICourseService extends IService<Course> {

    PageList<Course> findPage(CourseQuery query);

    /**
     * 上线
     * @param ids
     */
    void online(List<Long> ids);
    void offline(List<Long> ids);
}
