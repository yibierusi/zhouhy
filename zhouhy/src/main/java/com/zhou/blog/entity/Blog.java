package com.zhou.blog.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.zhou.index.entity.SysUser;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
@Data
public class Blog extends Model<Blog> {

    private static final long serialVersionUID = 1L;

    /**
     * 博客ID
     */
	private String id;
	private String title;
	private String content;
	@TableField("sys_user_id")
	private String sysUserId;

	@TableField(exist = false)//表示该属性不为数据库表字段，但又是必须使用的。
	private SysUser sysUser;
    /**
     * 阅读数
     */
	private Integer reads;
    /**
     * 评论数
     */
	private Integer comments;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;
    /**
     * 0：未删除  1：删除
     */
	@TableField("del_flag")
	private Integer delFlag;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
