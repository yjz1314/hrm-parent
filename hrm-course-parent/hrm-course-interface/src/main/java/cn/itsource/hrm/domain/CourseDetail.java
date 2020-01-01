package cn.itsource.hrm.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yjz
 * @since 2019-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_course_detail")
public class CourseDetail extends Model<CourseDetail> {

    private static final long serialVersionUID=1L;

    private Long courseId;

    /**
     * 详情
     */
    private String description;

    /**
     * 简介
     */
    private String intro;


    @Override
    protected Serializable pkVal() {
        return this.courseId;
    }





}
