package com.zhou.blog.service.impl;

import com.zhou.blog.dao.BlogMapper;
import com.zhou.blog.domain.Blog;
import com.zhou.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-12 20:58
 **/
@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogMapper dao;

    @Override
    public void addBlog(Blog blog) {
        dao.addBlog(blog);
    }

    @Override
    public Blog queryBlogById(String id) {
        return dao.queryBlogById(id);
    }

    @Override
    public Blog queryBlogByIdAndUserId(String id, String userId) {
        return dao.queryBlogByIdAndUserId(id,userId);
    }

    @Override
    public List<Blog> queryBlogListByAuthorId(String authorId) {
        return dao.queryBlogListByAuthorId(authorId);
    }

    @Override
    public int modifyBlogReadCountById(String id) {
        return dao.modifyBlogReadCountById(id);
    }

    @Override
    public int modifyBlog(Blog blog) {
        return dao.modifyBlog(blog);
    }

    @Override
    public int deleteBlog(String id ,String userId) {
        return dao.deleteBlog(id,userId);
    }
}
