package com.zhou.photo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "PHOTO_ALBUM")
public class PhotoAlbum {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "AUTHOR_ID")
    private String authorId;

    @Column(name = "PHOTO_ID")
    private String photoId;

    @Column(name = "READ_COUNT")
    private Long readCount;

    @Column(name = "COMMENT_COUNT")
    private Long commentCount;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "DEL_FLAG")
    private String delFlag;

    /**
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return CONTENT
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return AUTHOR_ID
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
    }

    /**
     * @return PHOTO_ID
     */
    public String getPhotoId() {
        return photoId;
    }

    /**
     * @param photoId
     */
    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    /**
     * @return READ_COUNT
     */
    public Long getReadCount() {
        return readCount;
    }

    /**
     * @param readCount
     */
    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    /**
     * @return COMMENT_COUNT
     */
    public Long getCommentCount() {
        return commentCount;
    }

    /**
     * @param commentCount
     */
    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return DEL_FLAG
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}