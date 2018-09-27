package com.zhou.bill.controller;


import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.entity.BillTag;
import com.zhou.bill.service.BillDetailService;
import com.zhou.bill.service.BillService;
import com.zhou.bill.service.BillTagService;
import com.zhou.index.comm.util.StringHelper;
import com.zhou.index.entity.Result;
import com.zhou.index.entity.SysUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/detail")
public class BillDetailController {
    @Autowired
    private BillService billService;
    @Autowired
    private BillDetailService billDetailService;
    @Autowired
    private BillTagService billTagService;

    /**
     * @Author: zhouhy
     * @Description: 详情管理
     * mold :1 添加模式  mold :2 修改模式
     * @Date: 14:08 2018/8/23
     */
    @RequestMapping(value = "/index/{mold}")
    public ModelAndView detail(HttpServletRequest request, String date, String billId,
                               String billDetail,
                               @PathVariable("mold") Integer mold) {
        date = StringHelper.removeSymbol(date);
        ModelAndView mav = new ModelAndView("bill/detail_manage");
        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        Bill bill = null;
        if (billId == null || StringUtils.isEmpty(billId)) {
            Integer dateInt = StringUtils.isEmpty(date) ? null : Integer.parseInt(date);
            bill = billService.getBillBySysUserIdAndDate(su.getId(), dateInt);
        } else {
            bill = billService.getBillBySysUserIdAndId(su.getId(), billId);
        }
        if (bill == null) {
            bill = new Bill();
        }

        List<BillDetail> bds = billDetailService.getBillDetailListByBillId(bill.getId());
        BillDetail bd = new BillDetail();
        if (StringUtils.isNotEmpty(billDetail)) {
            bd = billDetailService.selectById(billDetail);
        }

        List<BillTag> tags = billTagService.getBillTagsBySysUserId(su.getId());
        mav.addObject("tags", tags);
        mav.addObject("bd", bd);
        mav.addObject("bds", bds);
        mav.addObject("bill", bill);
        mav.addObject("mold", mold);
        return mav;
    }


    /**
     * 更新或者修改
     */
    @ResponseBody
    @RequestMapping(value = "/save")
    public Result save(HttpServletRequest request, BillDetail billDetail) {

        SysUser su = (SysUser) request.getSession().getAttribute("sysUser");
        boolean flag = billDetailService.save(su.getId(), billDetail);
        if (flag) {
            return Result.ok();
        }
        return Result.error();
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public Result delete(String id) {
        BillDetail billDetail = billDetailService.selectById(id);
        boolean flag = billDetailService.deleteById(id);
        if (flag) {
            //更新当天支出收入
            billService.updateBillAll(billDetail.getType(), billDetail.getBillId());
            return Result.ok();
        }
        return Result.error();
    }
}
