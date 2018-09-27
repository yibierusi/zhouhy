package com.zhou.index.service;

import com.zhou.index.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 根据用户名密码查询SysUser 对象
     *
     * @return
     */
    SysUser getSysUserByUsernameAndPassword(SysUser su);

    SysUser getSysUserByUsernameAndPassword(String username, String password);
}
