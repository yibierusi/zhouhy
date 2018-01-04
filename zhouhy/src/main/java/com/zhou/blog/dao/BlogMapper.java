package com.zhou.blog.dao;

import com.zhou.blog.domain.Blog;
import com.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedNotifications;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-12 20:55
 **/
public interface BlogMapper extends MyMapper<Blog>{
    void addBlog(Blog blog);

    Blog queryBlogById(String id);

    Blog queryBlogByIdAndUserId(@Param("id") String id, @Param("userId") String userId);

    List<Blog> queryBlogListByAuthorId(String authorId);

    int modifyBlogReadCountById(String id) ;

    int modifyBlog(Blog blog);

    int deleteBlog(@Param("id") String id,@Param("userId") String userId) ;
}
