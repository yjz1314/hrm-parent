package cn.itsource.hrm.mapper;

import cn.itsource.hrm.domain.Course;
import cn.itsource.hrm.query.CourseQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjz
 * @since 2019-12-31
 */
public interface CourseMapper extends BaseMapper<Course> {
    long countByQuery(CourseQuery query);

    IPage<Course> myPage(Page page, @Param("query") CourseQuery query);

    void online(@Param("ids") List<Long> ids, @Param("time") long time);

    void offline(@Param("ids") List<Long> ids, @Param("time") long time);
}
