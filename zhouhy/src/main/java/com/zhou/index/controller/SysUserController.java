package com.zhou.index.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import com.zhou.index.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 10:40
 **/
@Controller
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    /**
     * 登录操作
     **/
    @PostMapping(value = "/login")
    public @ResponseBody Result login(SysUser su, HttpServletRequest request) {
        if (StringUtils.isEmpty(su.getUsername().trim())) {
            return new Result(101, "用户名不能为空", null);
        }
        if (StringUtils.isEmpty(su.getPassword().trim())) {
            return new Result(102, "密码不能为空", null);
        }

        EntityWrapper<SysUser> ew = new EntityWrapper<>();
        ew.where("username={0}", su.getUsername());
        ew.where("password={0}", su.getPassword());
        SysUser sysUser = sysUserService.selectOne(ew);
        if (sysUser != null) {
            request.getSession().setAttribute("sysUser", sysUser);
            return new Result(200,"登陆成功",null);
        } else
            return new Result(201,"用户不存在",null);
    }


}
