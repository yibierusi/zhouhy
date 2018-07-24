package com.zhou.blog.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.blog.entity.Blog;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
public interface BlogService extends IService<Blog> {
    //查询blog
    List<Blog> selectBlog(EntityWrapper<Blog> ew);
	
}
