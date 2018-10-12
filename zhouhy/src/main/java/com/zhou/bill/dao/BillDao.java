package com.zhou.bill.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zhou.bill.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  账单流水Mapper 接口
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillDao extends BaseMapper<Bill> {
    void updateSum();

    /**
     * 查询某月的支出数据
     * @param st
     * @param et
     * @param sysUserId
     * @return
     */
    List<Bill> getCertainMonthData(@Param("st")String st,@Param("et")String et,@Param("sysUserId")String sysUserId);
}