package cn.itsource.hrm.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_course")
public class Course extends Model<Course> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 适用人群
     */
    private String users;

    /**
     * 课程大分类
     */
    private Long courseTypeId;

    /**
     * 课程等级
     */
    private Long grade;

    /**
     * 课程状态
     */
    private Integer status;

    /**
     * 教育机构
     */
    private Long tenantId;

    @TableField("tenantName")
    private String tenantName;

    /**
     * 创建用户
     */
    private Long userId;

    @TableField("userName")
    private String userName;

    private Long startTime;

    private Long endTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @TableField(exist = false)
    private CourseType courseType;

}
