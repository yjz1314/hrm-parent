package cn.itsource.hrm.document;

import lombok.Data;
import lombok.ToString;

/**
 * @Description: TODO
 * @Date: 2020/1/8 00:01
 * @Author: yjz
 * @Version:1.0
 */
@Data
@ToString
public class CourseDocumentQuery {

    private Integer page;
    private Integer rows;
    private String keyword;
    private Long courseTypeId;

    private Double minPrice;
    private Double maxPrice;

    //排序
    private String orderField;
    private Integer orderType;

}
