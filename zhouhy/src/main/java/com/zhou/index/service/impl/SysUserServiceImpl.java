package com.zhou.index.service.impl;

import com.zhou.index.dao.SysUserMapper;
import com.zhou.index.domain.SysUser;
import com.zhou.index.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 11:51
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper dao;

    @Override
    public SysUser querySysUserByUsernameAndPassword(String username, String password) {
        return dao.querySysUserByUsernameAndPassword(username,password);
    }

    @Override
    public String queryUserIdByUsernameAndPassword(String username, String password) {
        return dao.queryUserIdByUsernameAndPassword(username,password);
    }
}
