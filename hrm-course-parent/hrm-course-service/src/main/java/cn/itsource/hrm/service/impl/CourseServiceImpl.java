package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.mapper.CourseMapper;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.service.ICourseService;
import cn.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjz
 * @since 2019-12-31
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Override
    public PageList<Course> findPage(CourseQuery query) {
        IPage<Course> iPage = baseMapper.myPage(new Page(query.getPage(), query.getRows()), query);
        return new PageList<>(iPage.getTotal(),iPage.getRecords());
    }
}
