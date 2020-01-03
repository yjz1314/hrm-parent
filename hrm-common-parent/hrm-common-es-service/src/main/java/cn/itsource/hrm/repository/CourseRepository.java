package cn.itsource.hrm.repository;

import cn.itsource.hrm.document.CourseDoucment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: TODO
 * @Date: 2020/1/1 20:30
 * @Author: yjz
 * @Version:1.0
 */
@Repository
public interface CourseRepository extends ElasticsearchRepository<CourseDoucment,Long> {

}
