package com.zhou.photo.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouhy
 * @since 2018-07-06
 */
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
	@TableField("del_flag")
	private Integer delFlag;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhotoAlbumId() {
		return photoAlbumId;
	}

	public void setPhotoAlbumId(String photoAlbumId) {
		this.photoAlbumId = photoAlbumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getBytes() {
		return bytes;
	}

	public void setBytes(Integer bytes) {
		this.bytes = bytes;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
		return "Photo{" +
			"id=" + id +
			", photoAlbumId=" + photoAlbumId +
			", name=" + name +
			", path=" + path +
			", suffix=" + suffix +
			", bytes=" + bytes +
			", content=" + content +
			", reads=" + reads +
			", comments=" + comments +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			", delFlag=" + delFlag +
			"}";
	}
}
