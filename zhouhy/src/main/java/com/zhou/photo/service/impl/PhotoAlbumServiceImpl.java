package com.zhou.photo.service.impl;

import com.zhou.index.service.BaseService;
import com.zhou.photo.domain.PhotoAlbum;
import com.zhou.photo.service.PhotoAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhou.photo.dao.PhotoAlbumMapper;

/*
 * @作者：zhouhy
 * @描述：相册实现类
 * @时间：2018/1/5  10:45
 */
@Service
public class PhotoAlbumServiceImpl extends BaseService<PhotoAlbum> implements PhotoAlbumService {
    @Autowired
    private PhotoAlbumMapper dao;

    public void test(){
        
    }

}
