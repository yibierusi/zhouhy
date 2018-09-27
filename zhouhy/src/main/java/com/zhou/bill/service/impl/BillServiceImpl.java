package com.zhou.bill.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.bill.dao.BillDao;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillDetail;
import com.zhou.bill.entity.BillListQueryParam;
import com.zhou.bill.service.BillDetailService;
import com.zhou.bill.service.BillService;
import com.zhou.bill.service.BillTagService;
import com.zhou.index.comm.util.DateHelper;
import com.zhou.index.comm.util.UUIDHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账单流水服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillDao, Bill> implements BillService {
    @Autowired
    private BillDao dao;
    @Autowired
    private BillDetailService billDetailService;
    @Autowired
    private BillTagService billTagService;

    @Override
    public void updateBillAll(String detailId) {
        BillDetail billDetail = billDetailService.selectById(detailId);
        this.updateBillAll(billDetail.getType(), billDetail.getBillId());
    }

    @Override
    public void updateBillAll(Integer type, String id) {
        //更新当天支出收入
        this.updateSum();
        //获取当天支出收入最大值
        BillDetail max = billDetailService.getMaxMoney(type, id);
        Bill bill = this.selectById(id);
        if (max == null) {
            max = new BillDetail();
        }
        if (type == 2) {
            bill.setMaxIncome(max.getMoney());
            bill.setMaxIncomeExplain(billTagService.getTagNames(max.getBillTagIds()));
        } else {
            bill.setMaxPaid(max.getMoney());
            bill.setMaxPaidExplain(billTagService.getTagNames(max.getBillTagIds()));
        }

        this.updateById(bill);
    }

    @Override
    public void updateSum() {
        dao.updateSum();
    }

    /**
     * 获取账单的分页数据  根据用户ID 开始结束时间 用户ID
     *
     * @param param
     * @param sysUserId
     * @return
     */
    @Override
    public Page<Bill> getBillPageByBillListQueryParam(BillListQueryParam param, String sysUserId) {
        Page<Bill> page = new Page<>(param.getCurrent(), param.getSize(), "date");
        EntityWrapper<Bill> ew = new EntityWrapper<>();
        ew.eq("sys_user_id", sysUserId);
        ew.and("date >= {0}", param.getStartTime());
        ew.and("date <= {0}", param.getEndTime());

        return this.selectPage(page, ew);
    }

    /**
     * 查询账单根据用户ID和账单ID
     *
     * @param sysUserId
     * @param id
     * @return
     */
    @Override
    public Bill getBillBySysUserIdAndId(String sysUserId, String id) {
        EntityWrapper<Bill> ew = new EntityWrapper<>();
        ew.eq("sys_user_id", sysUserId);
        ew.eq("id", id);
        return this.selectOne(ew);
    }

    /**
     * 查询账单根据用户ID和date
     *
     * @param sysUserId
     * @return
     * @paramdate
     */
    @Override
    public Bill getBillBySysUserIdAndDate(String sysUserId, Integer date) {
        if (date == null || date == 0) {
            date = DateHelper.getYMD(0, 0, 0, 0);
        }
        EntityWrapper<Bill> ew = new EntityWrapper<>();
        ew.eq("sys_user_id", sysUserId);
        ew.eq("date", date);
        Bill bill = this.selectOne(ew);
        if (bill == null) {
            bill = new Bill();
            bill.setDate(date);
            bill.setSysUserId(sysUserId);
            bill.setId(UUIDHelper.getUUID());
            bill.setStatus(1);
            this.insert(bill);
        }
        return bill;
    }

}
