package com.zhou.index.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.zhou.index.entity.SysUserRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-11-12
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    /**
     * 根据用户ID获取
     * @param userid
     * @return
     */
    List<SysUserRole> getSysUserRolesByUserId(String userid);
}
