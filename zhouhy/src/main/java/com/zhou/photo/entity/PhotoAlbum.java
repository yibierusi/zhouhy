package com.zhou.photo.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("photo_album")
public class PhotoAlbum extends Model<PhotoAlbum> {

    private static final long serialVersionUID = 1L;

    /**
     * 相册ID
     */
	private String id;
    /**
     * 相册名字
     */
	private String name;
	private String content;
    /**
     * 用户ID
     */
	@TableField("sys_user_id")
	private String sysUserId;
    /**
     * 相册ID
     */
	@TableField("photo_id")
	private String photoId;
	@TableField("photo_path")
	private String photoPath;
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
     * 0：未删除 1：删除
     */
	@TableField("del_flag")
	private Integer delFlag;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
