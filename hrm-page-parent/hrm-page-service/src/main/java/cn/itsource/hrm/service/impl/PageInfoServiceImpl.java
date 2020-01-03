package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.domain.PageInfo;
import cn.itsource.hrm.mapper.PageInfoMapper;
import cn.itsource.hrm.query.PageInfoQuery;
import cn.itsource.hrm.service.IPageInfoService;
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
 * @since 2020-01-02
 */
@Service
public class PageInfoServiceImpl extends ServiceImpl<PageInfoMapper, PageInfo> implements IPageInfoService {
    @Override
    public PageList<PageInfo> getByQuery(PageInfoQuery query) {
        Page page = new Page(query.getPage(),query.getRows());
        IPage<PageInfo> infoIPage = baseMapper.selectByPage(page,query);

        return new PageList<>(infoIPage.getTotal(),infoIPage.getRecords());
    }
}
