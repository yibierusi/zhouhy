package com.zhou.index.controller;

import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import com.zhou.index.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
            return new Result(101, "用户名不能为空");
        }
        if (StringUtils.isEmpty(su.getPassword().trim())) {
            return new Result(102, "密码不能为空");
        }
        SysUser sysUser = sysUserService.getSysUserByUsernameAndPassword(su);

        if (sysUser != null) {
            request.getSession().setAttribute("sysUser", sysUser);
            return new Result(200, "登陆成功");
        } else {
            return new Result(201, "用户名或者密码错误");
        }
    }

    /**
     * 登出操作
     **/
    @GetMapping(value = "/logout")
    public @ResponseBody Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute("sysUser");
        return Result.ok();
    }


}
