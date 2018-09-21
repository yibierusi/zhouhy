package com.zhou.bill.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.dao.BillDetailDao;
import com.zhou.bill.service.BillDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Service
public class BillDetailServiceImpl extends ServiceImpl<BillDetailDao, BillDetail> implements BillDetailService {
    @Autowired
    private BillService billService;

    /**
     * 获取详情分页数据  根据时间（或者账单ID） 用户ID
     */
    @Override
    public List<BillDetail> getBillDetailListBySysUserIdAndDateOrDetailId(String sysUserId, Integer date, String billId) {
        if (billId == null || StringUtils.isEmpty(billId)){
            Bill bill = billService.getBillBySysUserIdAndDate(sysUserId,date);
            //数据不存在
            if (StringUtils.isEmpty(bill)) {
                return null;
            }
            billId = bill.getId();
        }

        EntityWrapper<BillDetail> ew = new EntityWrapper<>();

        ew.eq("bill_id", billId);

        return this.selectList(ew);
    }
}
