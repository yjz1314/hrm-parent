package cn.itsource.hrm.query;

import lombok.Data;

/**
 * <p>
 *  查询参数对象
 * </p>
 *
 * @author yjz
 * @since 2019-12-31
 */
@Data
public class CourseQuery extends BaseQuery {
    private Integer status;

    private Long courseTypeId;

    private Double minPrice;
    private Double maxPrice;

    //排序
    private String orderField;// jg 表示price列   xp 表示startTime列
    private Integer orderType;//1 表示降序  0表示升序

}