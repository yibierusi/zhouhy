package com.zhou.bill.controller;


import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillListQueryParam;
import com.zhou.bill.service.BillService;
import com.zhou.index.comm.util.DateHelper;
import com.zhou.index.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    private BillService billService;


    /**
     * @Author: zhouhy
     * @Description: 图表
     * @Date: 14:08 2018/8/23
     */
    @RequestMapping(value = "/index")
    public ModelAndView charts(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("bill/chart");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        int[] x = DateHelper.get31Array();

        List<Bill> currentMothData = billService.getCertainMonthData(0, su.getId());
        List<Bill> lastMonthData = billService.getCertainMonthData(-1, su.getId());

        double[] current = billService.completionMonthData(currentMothData, x);
        double[] last = billService.completionMonthData(lastMonthData, x);
        
        mav.addObject("current", current);
        mav.addObject("last", last);
        mav.addObject("x", x);
        return mav;
    }


}
