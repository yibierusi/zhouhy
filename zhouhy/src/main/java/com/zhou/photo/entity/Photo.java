package com.zhou.photo.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
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
public class Photo extends Model<Photo> {

    private static final long serialVersionUID = 1L;

    /**
     * 照片ID
     */
	private String id;
    /**
     * 相册ID
     */
	@TableField("photo_album_id")
	private String photoAlbumId;
    /**
     * 照片名字
     */
	private String name;
    /**
     * 路径
     */
	private String path;
    /**
     * 后缀
     */
	private String suffix;
    /**
     * 大小
     */
	private Integer bytes;
	private String content;
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
	private Integer state;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
