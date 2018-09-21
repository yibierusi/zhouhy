package com.zhou.bill.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.entity.BillListQueryParam;
import com.zhou.bill.service.BillDetailService;
import com.zhou.bill.service.BillService;
import com.zhou.index.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 账单流水Controller
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;

    /**
     * @Author: zhouhy
     * @Description: 列表
     * @Date: 14:08 2018/8/23
     */
    @RequestMapping(value = "/bill")
    public ModelAndView bill(BillListQueryParam param, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("/bill/bill_list");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        Page<Bill> page = billService.getBillPageByBillListQueryParam(param, su.getId());
        mav.addObject("page", page);
        return mav;
    }

    /**
     * @Author: zhouhy
     * @Description: 详情管理
     * @Date: 14:08 2018/8/23
     */
    @RequestMapping(value = "/detail")
    public ModelAndView detail(HttpServletRequest request, Integer date, String billId) {
        ModelAndView mav = new ModelAndView("/bill/detail_manage");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        List<BillDetail> bds = billDetailService.getBillDetailListBySysUserIdAndDateOrDetailId(su.getId(), date, billId);
        mav.addObject("bds", bds);
        return mav;
    }


}
