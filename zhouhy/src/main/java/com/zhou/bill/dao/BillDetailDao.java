package com.zhou.bill.dao;

import com.zhou.bill.entity.BillDetail;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillDetailDao extends BaseMapper<BillDetail> {
    BillDetail getMaxMoney(@Param("type")Integer type ,@Param("billId")String billId);
}