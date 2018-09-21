package com.zhou.bill.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.bill.dao.BillDao;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillListQueryParam;
import com.zhou.bill.service.BillService;
import com.zhou.index.comm.util.DateUtil;
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
        if (date == null) {
            date = DateUtil.getYMD(0,0,0,0);
        }
        EntityWrapper<Bill> ew = new EntityWrapper<>();
        ew.eq("sys_user_id", sysUserId);
        ew.eq("date", date);
        return this.selectOne(ew);
    }
}
