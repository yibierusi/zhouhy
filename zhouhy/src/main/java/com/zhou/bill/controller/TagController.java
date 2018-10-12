package com.zhou.bill.controller;


import com.zhou.bill.entity.BillTag;
import com.zhou.bill.service.BillTagService;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class TagController {
    @Autowired
    private BillTagService billTagService;

    /**
     * 标签管理界面
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("bill/tag");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        List<BillTag> billTags = billTagService.getBillTagsBySysUserId(su.getId());
        mav.addObject("billTags", billTags);
        return mav;
    }


    /**
     * 标签管理-标签添加
     */
    @ResponseBody
    @RequestMapping(value = "/insert")
    public Result insert(HttpServletRequest request, String tagNames) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        billTagService.batchInsert(su.getId(), tagNames);
        return Result.ok();
    }

    /**
     * 标签管理-标签更新
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Result update(HttpServletRequest request, BillTag tag) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        billTagService.updateById(tag);
        return Result.ok();
    }

    /**
     * 标签管理-标签删除
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Result delete(HttpServletRequest request, String id) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        billTagService.deleteTagByIdAndSysUserId(id, su.getId());
        return Result.ok();
    }

    /**
     * 标签管理-标签获取
     */
    @ResponseBody
    @RequestMapping(value = "/queryById")
    public Result queryById(HttpServletRequest request, String id) {
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        BillTag billTag = billTagService.getTagByIdAndSysUserId(id, su.getId());
        return Result.ok().put("billTag", billTag);
    }
}
