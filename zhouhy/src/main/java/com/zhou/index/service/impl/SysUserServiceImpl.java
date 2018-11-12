package com.zhou.index.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.index.entity.SysUser;
import com.zhou.index.dao.SysUserDao;
import com.zhou.index.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {
    /**
     * 根据用户名密码查询SysUser 对象
     *
     * @return
     */
    @Override
    public SysUser getSysUserByUsernameAndPassword(SysUser su) {
        return getSysUserByUsernameAndPassword(su.getUsername(), su.getPassword());
    }

    @Override
    public SysUser getSysUserByUsernameAndPassword(String username, String password) {
        EntityWrapper<SysUser> ew = new EntityWrapper<>();
        ew.and("username", username);
        ew.and("password", password);
        return this.selectOne(ew);
    }

    /**
     * 根据用户名获取SysUser
     * @param username
     * @return
     */
    @Override
    public SysUser getSysUserByUsername(String username) {
        EntityWrapper<SysUser> ew = new EntityWrapper<>();
        ew.and("username", username);
        return this.selectOne(ew);
    }
}
