package com.zhou.index.service;

/**
 * Created by zhouhy on 2018/1/4.
 */

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 */
@Service
public interface IService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    int insertSelective(T entity);

    List<T> select(T entity);

    int updateByPrimaryKeySelective(T entity);

    //TODO 其他...
}