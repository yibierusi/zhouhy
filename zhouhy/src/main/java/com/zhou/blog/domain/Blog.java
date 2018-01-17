package com.zhou.blog.domain;


import com.zhou.index.domain.SysUser;

import java.util.Date;
import javax.persistence.*;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-12 20:53
 **/
@Table(name = "BLOG")
public class Blog {
    /**
     * 博客id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    private String id;

    /**
     * 博客标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 博客内容
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 作者ID
     */
    @Column(name = "AUTHOR_ID")
    private String authorId;

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
     * 发表时间
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
     * 获取博客id
     *
     * @return ID - 博客id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置博客id
     *
     * @param id 博客id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取博客标题
     *
     * @return TITLE - 博客标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置博客标题
     *
     * @param title 博客标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取博客内容
     *
     * @return CONTENT - 博客内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置博客内容
     *
     * @param content 博客内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取作者ID
     *
     * @return AUTHOR_ID - 作者ID
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * 设置作者ID
     *
     * @param authorId 作者ID
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId == null ? null : authorId.trim();
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
     * 获取发表时间
     *
     * @return CREATE_TIME - 发表时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置发表时间
     *
     * @param createTime 发表时间
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