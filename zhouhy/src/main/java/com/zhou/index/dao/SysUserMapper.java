package com.zhou.index.dao;

import com.MyMapper;
import com.zhou.index.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Title：
 * Description：Component注解不添加也没事，只是不加service那边引入LearnMapper会有错误提示，但不影响
 *
 * @author: zhouhy
 * @create 2017-11-09 11:52
 **/
public interface SysUserMapper extends MyMapper<SysUser>{

    //简单的语句只需要使用@Insert、@Update、@Delete、@Select这4个注解即可，但是有些复杂点需要动态SQL语句，就比如上面方法中根据查询条件是否有值来动态添加sql的，就需要使用@InsertProvider、@UpdateProvider、@DeleteProvider、@SelectProvider等注解。
    SysUser querySysUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    String queryUserIdByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
