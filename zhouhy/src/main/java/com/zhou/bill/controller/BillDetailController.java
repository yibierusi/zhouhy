package com.zhou.bill.controller;


import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.service.BillDetailService;
import com.zhou.bill.service.BillService;
import com.zhou.index.comm.util.DateUtil;
import com.zhou.index.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Controller
@RequestMapping("/detail")
public class BillDetailController {
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;
    /**
     * @Author: zhouhy
     * @Description: 详情管理
     * @Date: 14:08 2018/8/23
     */
    @RequestMapping(value = "/index")
    public ModelAndView detail(HttpServletRequest request, Integer date, String billId) {
        ModelAndView mav = new ModelAndView("/bill/detail_manage");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        Bill bill = null;
        if (billId == null || StringUtils.isEmpty(billId)){
            bill = billService.getBillBySysUserIdAndDate(su.getId(),date);
        }else {
            bill = billService.getBillBySysUserIdAndId(su.getId(),billId);
        }
        if (bill == null){
            bill = new Bill();
        }

        List<BillDetail> bds = billDetailService.getBillDetailListByBillId(bill.getId());
        mav.addObject("bds", bds);
        mav.addObject("bill", bill);
        return mav;
    }
}
