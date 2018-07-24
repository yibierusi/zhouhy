package com.zhou.photo.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Integer getReads() {
		return reads;
	}

	public void setReads(Integer reads) {
		this.reads = reads;
	}

	public Integer getComments() {
		return comments;
	}

	public void setComments(Integer comments) {
		this.comments = comments;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "PhotoAlbum{" +
			"id=" + id +
			", name=" + name +
			", content=" + content +
			", sysUserId=" + sysUserId +
			", photoId=" + photoId +
			", photoPath=" + photoPath +
			", reads=" + reads +
			", comments=" + comments +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", delFlag=" + delFlag +
			"}";
	}
}
