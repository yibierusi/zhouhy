package com.zhou.bill.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.zhou.bill.entity.BillDetail;
import com.baomidou.mybatisplus.service.IService;
import com.zhou.bill.entity.BillListQueryParam;

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
     * 获取详情数据  根据时间（或者账单ID） 用户ID
     */
    List<BillDetail> getBillDetailListBySysUserIdAndDateOrDetailId(String sysUserId, Integer date, String billId);
}
