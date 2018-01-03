package com.zhou.index.controller;

import com.zhou.index.domain.SysUser;
import com.zhou.index.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 10:40
 **/
@Controller
public class UserController {
    @Autowired
    SysUserService userService;
    /**
     *登录操作
     **/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(SysUser su, HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map =new HashMap<>();
        SysUser sysUser = userService.querySysUserByUsernameAndPassword(su.getUsername(),su.getPassword());
        if(sysUser!=null) {
            request.getSession().setAttribute("sysUser", sysUser);
            map.put("result", "1");
        }else
            map.put("result","0");
        return map;
    }


}
