package com.zhou.photo.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "PHOTO")
public class Photo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    private String id;

    @Column(name = "PHOTO_ALBUM_ID")
    private String photoAlbumId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PATH")
    private String path;

    @Column(name = "SUFFIX")
    private String suffix;

    @Column(name = "SIZE1")
    private String size1;

    @Column(name = "CONTENT")
    private String content;

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
     * @return PHOTO_ALBUM_ID
     */
    public String getPhotoAlbumId() {
        return photoAlbumId;
    }

    /**
     * @param photoAlbumId
     */
    public void setPhotoAlbumId(String photoAlbumId) {
        this.photoAlbumId = photoAlbumId == null ? null : photoAlbumId.trim();
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
     * @return PATH
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * @return SUFFIX
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * @param suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? null : suffix.trim();
    }

    /**
     * @return SIZE1
     */
    public String getSize1() {
        return size1;
    }

    /**
     * @param size1
     */
    public void setSize1(String size1) {
        this.size1 = size1 == null ? null : size1.trim();
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