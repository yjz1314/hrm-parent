package cn.itsource.hrm.mapper;

import cn.itsource.hrm.domain.PageInfo;
import cn.itsource.hrm.query.PageInfoQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yjz
 * @since 2020-01-02
 */
public interface PageInfoMapper extends BaseMapper<PageInfo> {
    IPage<PageInfo> selectByPage(Page page, @Param("query") PageInfoQuery query);

    IPage<PageInfo> selectByQuery(Page page, PageInfoQuery query);
}
