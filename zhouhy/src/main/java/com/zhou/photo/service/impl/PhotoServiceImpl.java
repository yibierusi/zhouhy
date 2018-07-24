package com.zhou.photo.service.impl;

import com.zhou.photo.entity.Photo;
import com.zhou.photo.dao.PhotoDao;
import com.zhou.photo.service.PhotoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoDao, Photo> implements PhotoService {
	
}
