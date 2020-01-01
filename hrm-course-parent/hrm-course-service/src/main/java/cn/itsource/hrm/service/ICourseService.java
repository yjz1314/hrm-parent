package cn.itsource.hrm.service;

import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
