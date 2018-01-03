package com.zhou.blog.service;

import com.zhou.blog.domain.Blog;

import java.util.List;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-12 20:56
 **/
public interface BlogService {

    void addBlog(Blog blog);

    Blog queryBlogById(String id);

    Blog queryBlogByIdAndUserId(String id,String userId);

    List<Blog> queryBlogListByAuthorId(String authorId);

    int modifyBlogReadCountById(String id);

    int modifyBlog(Blog blog);

    int deleteBlog(String id,String userId);


}
