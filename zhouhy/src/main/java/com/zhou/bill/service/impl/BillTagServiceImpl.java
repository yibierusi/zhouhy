package com.zhou.bill.service.impl;

import com.zhou.bill.entity.BillTag;
import com.zhou.bill.dao.BillTagDao;
import com.zhou.bill.service.BillTagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.index.comm.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Service
public class BillTagServiceImpl extends ServiceImpl<BillTagDao, BillTag> implements BillTagService {
    @Autowired
    private BillTagDao dao;
    /**
     * 获取标签的名字的字符串
     * @param ids
     * @return
     */
    @Override
    public String getTagNames(String ids) {
        String[] idses = ids.split(",",-1);
        List<String> tagNames = dao.getTagNames(idses);
        return StringUtil.removeFirstAndLastChar(tagNames.toString());
    }
}
