package com.zhou.bill.controller;


import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.entity.BillTag;
import com.zhou.bill.service.BillTagService;
import com.zhou.index.comm.util.StringHelper;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Controller
@RequestMapping("/tag")
public class BillTagController {
    @Autowired
    private BillTagService billTagService;

    /**
     * 标签管理界面
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("bill/tag_manage");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        List<BillTag> billTags = billTagService.getBillTagsBySysUserId(su.getId());
        mav.addObject("billTags", billTags);
        return mav;
    }


    /**
     * 标签管理添加
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Result insert(HttpServletRequest request, String tagNames) {
        ModelAndView mav = new ModelAndView("bill/tag_manage");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        billTagService.batchInsert(su.getId(), tagNames);
        return Result.ok();
    }

    /**
     * 标签管理删除
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Result delete(HttpServletRequest request, String id) {
        ModelAndView mav = new ModelAndView("bill/tag_manage");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        billTagService.deleteTagByIdAndSysUserId(id, su.getId());
        return Result.ok();
    }
}
