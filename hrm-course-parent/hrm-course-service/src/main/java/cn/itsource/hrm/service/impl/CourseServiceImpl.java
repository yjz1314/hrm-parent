package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.client.CourseEsClient;
import cn.itsource.hrm.client.SystemDictionaryitemClient;
import cn.itsource.hrm.document.CourseDocumentQuery;
import cn.itsource.hrm.document.CourseDoucment;
import cn.itsource.hrm.domain.*;
import cn.itsource.hrm.mapper.*;
import cn.itsource.hrm.query.CourseQuery;
import cn.itsource.hrm.service.ICourseService;
import cn.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private CourseEsClient courseEsClient;
    @Autowired
    private SystemDictionaryitemClient systemDictionaryitemClient;
    @Autowired
    private CourseDetailMapper courseDetailMapper;
    @Autowired
    private CourseResourceMapper courseResourceMapper;
    @Autowired
    private CourseMarketMapper courseMarketMapper;
    @Autowired
    private CourseTypeMapper courseTypeMapper;

    @Override
    public PageList<Course> findPage(CourseQuery query) {
        IPage<Course> iPage = baseMapper.myPage(new Page(query.getPage(), query.getRows()), query);
        return new PageList<>(iPage.getTotal(),iPage.getRecords());
    }

    @Override
    @Transactional
    public void online(List<Long> ids) {
        //修改数据库状态
        baseMapper.online(ids,System.currentTimeMillis());
        //根据id查询课程信息
        List<Course> courses = baseMapper.selectBatchIds(ids);
        //调用es服务的接口
        List<CourseDoucment> courseDoucments = coursesToDocs(courses);
        courseEsClient.createIndexes(courseDoucments);
    }

    private List<CourseDoucment> coursesToDocs(List<Course> courses) {
        List<CourseDoucment> list = new ArrayList<>();
        CourseDoucment courseDoucment = null;
        for (Course course : courses) {
            courseDoucment = courseToDoc(course);
            list.add(courseDoucment);
        }
        return list;
    }
    private CourseDoucment courseToDoc(Course c) {
        CourseDoucment doucment = new CourseDoucment();
        BeanUtils.copyProperties(c, doucment);
        Long courseTypeId = c.getCourseTypeId();
        CourseType courseType = courseTypeMapper.selectById(courseTypeId);
        doucment.setCourseTypeName(courseType.getName());
        doucment.setGradeId(c.getGrade());
        Systemdictionaryitem systemdictionaryitem =
                systemDictionaryitemClient.get(c.getGrade());
        doucment.setGradeName(systemdictionaryitem==null?
                null:systemdictionaryitem.getName());
        CourseDetail courseDetail = courseDetailMapper.selectOne(
                new QueryWrapper<CourseDetail>()
                        .eq("course_id", c.getId())
        );
        doucment.setIntro(courseDetail==null?null:courseDetail.getIntro());
        CourseResource courseResource = courseResourceMapper.selectOne(
                new QueryWrapper<CourseResource>().eq("course_id", c.getId())
        );
        doucment.setResources(courseResource==null?
                null:courseResource.getResources());
        CourseMarket courseMarket = courseMarketMapper.selectOne(
                new QueryWrapper<CourseMarket>()
                        .eq("course_id", c.getId())
        );
        BeanUtils.copyProperties(courseMarket==null?new CourseMarket():courseMarket,
                doucment,"id");
        String all = c.getTenantName()+" "+
                (courseType==null?"":courseType.getName())+" "+c.getName();
        doucment.setAll(all);
        return doucment;
    }

    /**
     * 下线
     * @param ids
     */
    @Override
    public void offline(List<Long> ids) {
        //修改数据库状态
        baseMapper.offline(ids,System.currentTimeMillis());
        courseEsClient.deleteIndexes(ids);
    }

    @Override
    public PageList<CourseDoucment> pageOnline(CourseQuery query) {
        CourseDocumentQuery documentQuery = new CourseDocumentQuery();
        BeanUtils.copyProperties(query, documentQuery);
        return courseEsClient.searchIndexs(documentQuery);
    }

}
