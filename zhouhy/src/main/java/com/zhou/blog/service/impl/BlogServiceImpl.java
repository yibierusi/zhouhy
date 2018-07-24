package com.zhou.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.blog.entity.Blog;
import com.zhou.blog.dao.BlogDao;
import com.zhou.blog.service.BlogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogDao, Blog> implements BlogService {
    @Autowired
    private BlogDao blogDao;
    @Override
    public List<Blog> selectBlog(EntityWrapper<Blog> ew) {
        return blogDao.selectBlog(ew);
    }
}
