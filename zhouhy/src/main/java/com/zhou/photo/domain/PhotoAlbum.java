package com.zhou.photo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "PHOTO_ALBUM")
public class PhotoAlbum {
    /**
     * 相册ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    private String id;

    /**
     * 相册名字
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 相册介绍
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 相册所属人ID
     */
    @Column(name = "AUTHOR_ID")
    private String authorId;

    /**
     * 相册封面照片ID
     */
    @Column(name = "PHOTO_ID")
    private String photoId;

    /**
     * 相册封面照片地址
     */
    @Column(name = "PHOTO_PATH")
    private String photoPath;

    /**
     * 阅读数
     */
    @Column(name = "READ_COUNT")
    private Long readCount;

    /**
     * 评论数
     */
    @Column(name = "COMMENT_COUNT")
    private Long commentCount;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 是否删除 1：删除 0未删除
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;

    /**
     * 获取相册ID
     *
     * @return ID - 相册ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置相册ID
     *
     * @param id 相册ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取相册名字
     *
     * @return NAME - 相册名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置相册名字
     *
     * @param name 相册名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取相册介绍
     *
     * @return CONTENT - 相册介绍
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置相册介绍
     *
     * @param content 相册介绍
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取相册所属人ID
     *
     * @return AUTHOR_ID - 相册所属人ID
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * 设置相册所属人ID
     *
     * @param authorId 相册所属人ID
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    /**
     * 获取相册封面照片ID
     *
     * @return PHOTO_ID - 相册封面照片ID
     */
    public String getPhotoId() {
        return photoId;
    }

    /**
     * 设置相册封面照片ID
     *
     * @param photoId 相册封面照片ID
     */
    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    /**
     * 获取相册封面照片地址
     *
     * @return PHOTO_PATH - 相册封面照片地址
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * 设置相册封面照片地址
     *
     * @param photoPath 相册封面照片地址
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    /**
     * 获取阅读数
     *
     * @return READ_COUNT - 阅读数
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * 设置阅读数
     *
     * @param readCount 阅读数
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取评论数
     *
     * @return COMMENT_COUNT - 评论数
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数
     *
     * @param commentCount 评论数
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取是否删除 1：删除 0未删除
     *
     * @return DEL_FLAG - 是否删除 1：删除 0未删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置是否删除 1：删除 0未删除
     *
     * @param delFlag 是否删除 1：删除 0未删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}