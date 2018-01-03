package com.zhou.index.service;

import com.zhou.index.domain.SysUser;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 11:51
 **/
public interface SysUserService {
    SysUser querySysUserByUsernameAndPassword(String username, String password);

    String queryUserIdByUsernameAndPassword(String username, String password);
}
