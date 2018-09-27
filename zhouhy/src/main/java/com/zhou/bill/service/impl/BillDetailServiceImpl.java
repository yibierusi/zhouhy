package com.zhou.bill.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.dao.BillDetailDao;
import com.zhou.bill.service.BillDetailService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.bill.service.BillService;
import com.zhou.bill.service.BillTagService;
import com.zhou.index.comm.util.CollectionHelper;
import com.zhou.index.comm.util.StringHelper;
import com.zhou.index.comm.util.UUIDHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private BillDetailDao dao;
    @Autowired
    private BillService billService;
    @Autowired
    private BillTagService billTagService;

    @Override
    public BillDetail getMaxMoney(Integer type, String billId) {
        return dao.getMaxMoney(type, billId);
    }

    /**
     * 获取详情分页数据  根据账单ID
     */
    @Override
    public List<BillDetail> getBillDetailListByBillId(String billId) {
        EntityWrapper<BillDetail> ew = new EntityWrapper<>();
        ew.eq("bill_id", billId);
        List<BillDetail> billDetails = this.selectList(ew);
        if (billDetails == null || billDetails.size() == 0) {
            return null;
        }
        for (int i = 0; i < billDetails.size(); i++) {
            BillDetail temp = billDetails.get(i);
            temp.setBillTagIds(billTagService.getTagNames(temp.getBillTagIds()));
        }
        return billDetails;
    }

    /**
     * 插入或者更新
     */
    @Override
    public boolean save(String sysUserId, BillDetail billDetail) {
        if (StringUtils.isEmpty(billDetail.getId())) {
            billDetail.setId(UUIDHelper.getUUID());
        }
        boolean flag = this.insertOrUpdate(billDetail);
        //更新当天支出收入
        billService.updateBillAll(billDetail.getType(), billDetail.getBillId());
        return flag;
    }
}
