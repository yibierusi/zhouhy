package com.zhou.bill.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.dao.BillDetailDao;
import com.zhou.bill.service.BillDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.bill.service.BillService;
import com.zhou.bill.service.BillTagService;
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
    @Autowired
    private BillTagService billTagService;

    /**
     * 获取详情分页数据  根据账单ID
     */
    @Override
    public List<BillDetail> getBillDetailListByBillId(String billId) {
        EntityWrapper<BillDetail> ew = new EntityWrapper<>();
        ew.eq("bill_id", billId);
        List<BillDetail> billDetails = this.selectList(ew);
        if (billDetails == null || billDetails.size() == 0){
            return null;
        }
        for (int i = 0; i < billDetails.size(); i++) {
            BillDetail temp = billDetails.get(i);
            temp.setBillTagIds(billTagService.getTagNames(temp.getBillTagIds()));
        }
        return billDetails;
    }
}
