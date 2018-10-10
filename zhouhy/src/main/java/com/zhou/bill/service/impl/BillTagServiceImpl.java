package com.zhou.bill.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.bill.entity.BillTag;
import com.zhou.bill.dao.BillTagDao;
import com.zhou.bill.service.BillTagService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.index.comm.util.StringHelper;
import com.zhou.index.comm.util.UUIDHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
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
     *
     * @param ids
     * @return
     */
    @Override
    public String getTagNames(String ids) {
        if (StringUtils.isEmpty(ids)) {
            return null;
        }
        String[] idses = ids.split(",", -1);
        List<String> tagNames = dao.getTagNames(idses);
        return StringHelper.removeFirstAndLastChar(tagNames.toString());
    }

    /**
     * 批量插入标签,并返回ID
     */
    @Override
    public List<String> batchInsert(String sysUserId, String tagNames) {
        tagNames = StringHelper.removeFirstChar(tagNames.trim());
        tagNames = tagNames.replaceAll(" ", "");
        if (StringUtils.isEmpty(tagNames)) {
            return null;
        }
        String[] tagNameArray = tagNames.split(",", -1);
        List<String> ids = new ArrayList<>();
        List<BillTag> bts = new ArrayList<>();

        BillTag bt = new BillTag();
        bt.setSysUserId(sysUserId);
        String uuid;
        for (int i = 0; i < tagNameArray.length; i++) {
            uuid = UUIDHelper.getUUID();
            BillTag temp = new BillTag();
            BeanUtils.copyProperties(bt, temp);
            temp.setId(uuid);
            temp.setName(tagNameArray[i]);
            ids.add(uuid);
            bts.add(temp);
        }
        boolean flag = this.insertBatch(bts);
        if (flag) {
            return ids;
        }
        return null;
    }

    @Override
    public List<BillTag> getBillTagsBySysUserId(String sysUserId) {
        EntityWrapper<BillTag> ew = new EntityWrapper<>();
        ew.orderBy("weight", true);
        ew.eq("sys_user_id", sysUserId);
        return this.selectList(ew);
    }

    @Override
    public boolean deleteTagByIdAndSysUserId(String id, String sysUserId) {
        EntityWrapper<BillTag> ew = new EntityWrapper<>();
        ew.eq("sys_user_id", sysUserId);
        ew.eq("id", id);
        return this.delete(ew);
    }

    @Override
    public BillTag getTagByIdAndSysUserId(String id, String sysUserId) {
        EntityWrapper<BillTag> ew = new EntityWrapper<>();
        ew.eq("id", id);
        ew.eq("sys_user_id", sysUserId);
        return this.selectOne(ew);
    }
}
