package com.zhou.index.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.index.entity.SysUserRole;
import com.zhou.index.dao.SysUserRoleDao;
import com.zhou.index.service.SysUserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-11-12
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {
    @Autowired
    private SysUserRoleDao dao;
    /**
     * 根据用户ID获取
     * @param userid
     * @return
     */
    @Override
    public List<SysUserRole> getSysUserRolesByUserId(String userid) {
        EntityWrapper<SysUserRole> ew = new EntityWrapper<>();
        ew.and("user_id",userid);
        List<SysUserRole> sysUserRoles= dao.selectList(ew);
        return sysUserRoles;
    }
}
