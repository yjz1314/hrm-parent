package cn.itsource.hrm.client.impl;

import cn.itsource.hrm.client.PageInfoClient;
import cn.itsource.hrm.domain.PageInfo;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Date: 2020/1/6 19:46
 * @Author: yjz
 * @Version:1.0
 */
@Component
public class PageInfoFallback implements PageInfoClient {
    @Override
    public PageInfo get(Long id) {
        return null;
    }
}
