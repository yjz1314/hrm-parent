package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.domain.PageConfig;
import cn.itsource.hrm.domain.PageInfo;
import cn.itsource.hrm.mapper.PageConfigMapper;
import cn.itsource.hrm.mapper.PageInfoMapper;
import cn.itsource.hrm.query.PageInfoQuery;
import cn.itsource.hrm.service.IPageInfoService;
import cn.itsource.hrm.util.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private PageConfigMapper pageConfigMapper;

    @Override
    public PageList<PageInfo> pageByQuery(PageInfoQuery query) {
        Page page = new Page(query.getPage(),query.getRows());
        IPage<PageInfo> infoIPage = baseMapper.selectByQuery(page,query);

        return new PageList<>(infoIPage.getTotal(),infoIPage.getRecords());
    }

    @Override
    @Transactional
    public boolean save(PageInfo pageInfo) {
        //添加 pageInfo表
        super.save(pageInfo);

        //添加pageConfig表
        PageConfig pageConfig = new PageConfig();
        pageConfig.setTemplateUrl(pageInfo.getTemplateUrl());
        pageConfig.setPhysicalPath(pageInfo.getPhysicalPath());
        pageConfig.setDfsType(0L);
        pageConfig.setPageId(pageInfo.getId());
        pageConfigMapper.insert(pageConfig);

        return true;
    }
}
