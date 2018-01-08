package com.zhou.index.controller;

import com.zhou.index.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
 * @create 2017-11-12 18:53
 **/
@Controller
public class TimeLineController {

    @RequestMapping(value = "/timeline")
    public ModelAndView timeline(SysUser su, HttpServletRequest request, HttpServletResponse response){
        ModelAndView mav = new ModelAndView("/zhou/timeline");
        return mav;
    }
}
