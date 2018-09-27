package com.zhou.index.controller;

import com.alibaba.fastjson.JSON;
import com.zhou.index.entity.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 19:56
 **/
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("zhou/index");
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        mav.addObject("sysUser", sysUser);
        return mav;
    }

    @RequestMapping(value = "/getSysUser")
    @ResponseBody
    public String getSysUser(HttpServletRequest request) {
        Map<String, Object> res = new HashMap<>();
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        res.put("su", su);
        return JSON.toJSONString(res);
    }
}
