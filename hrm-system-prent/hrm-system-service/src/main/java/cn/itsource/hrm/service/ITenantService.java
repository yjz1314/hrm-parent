package cn.itsource.hrm.service;

import cn.itsource.hrm.domain.Tenant;
import cn.itsource.hrm.web.dto.TenantDto;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjz
 * @since 2019-12-29
 */
public interface ITenantService extends IService<Tenant> {

    void registTenant(TenantDto tenantDto);
}
