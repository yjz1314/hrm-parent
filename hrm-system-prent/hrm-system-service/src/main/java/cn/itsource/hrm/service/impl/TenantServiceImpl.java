package cn.itsource.hrm.service.impl;

import cn.itsource.hrm.domain.*;
import cn.itsource.hrm.mapper.*;
import cn.itsource.hrm.service.ITenantService;
import cn.itsource.hrm.web.dto.TenantDto;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yjz
 * @since 2019-12-29
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

    @Autowired
    private MealPermissionMapper mealPermissionMapperl;

    @Autowired
    private TenantMealMapper tenantMealMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;


    @Override
    @Transactional
    public void registTenant(TenantDto tenantDto) {

        //保存租户表，返回租户id，mybatisplus默认返回主键
        Tenant tenant = tenantDto.getTenant();
        //设置初始值
        tenant.setState(0);
        tenant.setRegisterTime(System.currentTimeMillis());
        baseMapper.insert(tenant);
        //添加租户套餐中间表数据
        TenantMeal tm = new TenantMeal();
        tm.setTenantId(tenant.getId());
        tm.setMealId(tenantDto.getMeal());
        //设置初始值
        tm.setState(0);//未支付
        tm.setExpireDate(System.currentTimeMillis()+5*24*60*60*1000);//默认5天过期
        tenantMealMapper.insert(tm);

        //根据套餐id查询套餐所有的权限id
        List<MealPermission> mealPermissions = mealPermissionMapperl.selectList(
                new QueryWrapper<MealPermission>()
                        .eq("meal_id", tenantDto.getMeal())
        );
        //创建一个租户管理员的角色，获得角色的id
        Role role = new Role();
        role.setSn("TenantAdmin");
        role.setName("租户管理员");
        role.setTenant(tenant.getId());
        roleMapper.insert(role);
        //角色id   权限id  存  角色权限中间表
        List<RolePermission> list = new ArrayList<>();
        for (MealPermission mealPermission : mealPermissions) {
            Long permissionId = mealPermission.getPermissionId();
            RolePermission rp = new RolePermission();
            rp.setRoleId(role.getId());
            rp.setPermissionId(permissionId);
            list.add(rp);
        }
        if(list!=null&&list.size()>0){
            rolePermissionMapper.insertBatch(list);
        }


        //创建员工 - 分配角色 - 租户管理员
        Employee employee = new Employee();
        employee.setUsername(tenantDto.getUsername());
        employee.setPassword(tenantDto.getPassword());
        employee.setState(0);
        employee.setInputTime(System.currentTimeMillis());
        employee.setTenantId(tenant.getId());
        employee.setType(3);
        employeeMapper.insert(employee);

        //员工角色中间表
        EmployeeRole er = new EmployeeRole();
        er.setEmployeeId(employee.getId());
        er.setRoleId(role.getId());
        employeeRoleMapper.insert(er);
    }
}
