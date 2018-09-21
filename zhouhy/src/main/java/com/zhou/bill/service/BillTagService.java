package com.zhou.bill.service;

import com.zhou.bill.entity.BillTag;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
public interface BillTagService extends IService<BillTag> {
    /**
     * 获取标签的名字的字符串
     * @param ids
     * @return
     */
	String getTagNames(String ids);
}
