package com.zhou.bill.dao;

import com.zhou.bill.entity.BillTag;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillTagDao extends BaseMapper<BillTag> {
    /**
     * 获取标签的名字的字符串
     * @param ids
     * @return
     */
    List<String> getTagNames(String[] ids);
}