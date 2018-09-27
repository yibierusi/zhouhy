package com.zhou.bill.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zhou.bill.entity.BillDetail;
import com.baomidou.mybatisplus.service.IService;
import com.zhou.bill.entity.BillListQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillDetailService extends IService<BillDetail> {
    /**
     * 获取某天最大支出或收入
     */
    BillDetail getMaxMoney(@Param("type")Integer type , @Param("billId")String billId);
    /**
     * 获取详情分页数据  根据账单ID
     */
    List<BillDetail> getBillDetailListByBillId(String billId);

    /**
     * 插入或者更新
     */
    boolean save(String sysUserId, BillDetail billDetail);
}
