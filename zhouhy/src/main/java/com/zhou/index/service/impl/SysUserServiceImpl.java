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
        ew.where("username={0}", username);
        ew.where("password={0}", password);
        return this.selectOne(ew);
    }
}
