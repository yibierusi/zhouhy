package com.zhou.entry.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zhou.entry.dao.EntryDao;
import com.zhou.entry.entity.Entry;
import com.zhou.entry.service.EntryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-27
 */
@Service
public class EntryServiceImpl extends ServiceImpl<EntryDao, Entry> implements EntryService {
	
}
