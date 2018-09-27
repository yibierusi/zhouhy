package com.zhou.bill.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.zhou.bill.entity.Bill;
import com.zhou.bill.entity.BillListQueryParam;

/**
 * <p>
 *  账单流水服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillService extends IService<Bill> {
    /**
     * 更新支出收入值总和、最大值、说明
     */
    void updateBillAll(String detailId);
    /**
     * 更新支出收入值总和、最大值、说明
     */
    void updateBillAll(Integer type,String id);
    /**
     * 获取账单的分页数据  根据用户ID 开始结束时间 用户ID
     * @param param
     * @param sysUserId
     * @return
     */
    Page<Bill> getBillPageByBillListQueryParam(BillListQueryParam param, String sysUserId);

    /**
     * 查询账单根据用户ID和账单ID
     * @param sysUserId
     * @param id
     * @return
     */
    Bill getBillBySysUserIdAndId(String sysUserId,String id);

    /**
     * 查询账单根据用户ID和date 查询账单，若不存在则新建
     * @param sysUserId
     * @paramdate
     * @return
     */
    Bill getBillBySysUserIdAndDate(String sysUserId,Integer date);

    /**
     * 更新支付收入总和
     */
    void updateSum();
}
