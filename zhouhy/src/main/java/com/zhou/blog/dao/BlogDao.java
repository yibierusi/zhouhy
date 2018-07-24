package com.zhou.blog.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zhou.blog.entity.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */

public interface BlogDao extends BaseMapper<Blog> {

    //查询blog
    List<Blog> selectBlog(@Param("ew")EntityWrapper<Blog> ew);

}