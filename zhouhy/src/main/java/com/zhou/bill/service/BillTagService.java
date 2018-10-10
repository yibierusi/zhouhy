package com.zhou.bill.service;

import com.zhou.bill.entity.BillTag;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillTagService extends IService<BillTag> {
    /**
     * 获取标签的名字的字符串
     *
     * @param ids
     * @return
     */
    String getTagNames(String ids);

    /**
     * 批量插入标签,并返回ID
     */
    List<String> batchInsert(String sysUserId, String tagNames);

    /**
     * 获取标签
     *
     * @param sysUserId
     * @return
     */
    List<BillTag> getBillTagsBySysUserId(String sysUserId);

    /**
     * 删除
     */
    boolean deleteTagByIdAndSysUserId(String id, String sysUserId);

    /**
     * 查询
     */
    BillTag getTagByIdAndSysUserId(String id, String sysUserId);
}
