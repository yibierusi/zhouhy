package com.zhou.index.domain;

import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-09 10:24
 **/

@Table(name = "SYS_USER")
public class SysUser {
    /**
     * 用户主键
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    private String id;

    /**
     * 用户名字
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 用户密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 用户昵称
     */
    @Column(name = "NICKNAME")
    private String nickname;

    /**
     * 性别
     */
    @Column(name = "SEX")
    private String sex;

    /**
     * 生日
     */
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    /**
     * 头像
     */
    @Column(name = "ICO")
    private String ico;

    /**
     * 签名
     */
    @Column(name = "SIGNATURE")
    private String signature;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 电话
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 手机
     */
    @Column(name = "MOBILE")
    private String mobile;

    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    private String userType;

    /**
     * 用户状态
     */
    @Column(name = "USER_STATE")
    private String userState;

    /**
     * 登录时间
     */
    @Column(name = "LOGIN_TIME")
    private Date loginTime;

    /**
     * 登录IP
     */
    @Column(name = "LOGIN_IP")
    private String loginIp;

    /**
     * 注册时间
     */
    @Column(name = "REGISTERED_TIME")
    private Date registeredTime;

    /**
     * 注册IP
     */
    @Column(name = "REGISTERED_IP")
    private String registeredIp;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_BY")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    /**
     * 备注
     */
    @Column(name = "REMARKS")
    private String remarks;

    /**
     * 是否删除
     */
    @Column(name = "DEL_FLAG")
    private String delFlag;

    /**
     * 获取用户主键
     *
     * @return ID - 用户主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户主键
     *
     * @param id 用户主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户名字
     *
     * @return USERNAME - 用户名字
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名字
     *
     * @param username 用户名字
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取用户密码
     *
     * @return PASSWORD - 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password 用户密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户昵称
     *
     * @return NICKNAME - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取性别
     *
     * @return SEX - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取生日
     *
     * @return BIRTH_DATE - 生日
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置生日
     *
     * @param birthDate 生日
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取头像
     *
     * @return ICO - 头像
     */
    public String getIco() {
        return ico;
    }

    /**
     * 设置头像
     *
     * @param ico 头像
     */
    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    /**
     * 获取签名
     *
     * @return SIGNATURE - 签名
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 设置签名
     *
     * @param signature 签名
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取电话
     *
     * @return PHONE - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取手机
     *
     * @return MOBILE - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 获取用户类型
     *
     * @return USER_TYPE - 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    /**
     * 获取用户状态
     *
     * @return USER_STATE - 用户状态
     */
    public String getUserState() {
        return userState;
    }

    /**
     * 设置用户状态
     *
     * @param userState 用户状态
     */
    public void setUserState(String userState) {
        this.userState = userState == null ? null : userState.trim();
    }

    /**
     * 获取登录时间
     *
     * @return LOGIN_TIME - 登录时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登录时间
     *
     * @param loginTime 登录时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取登录IP
     *
     * @return LOGIN_IP - 登录IP
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置登录IP
     *
     * @param loginIp 登录IP
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    /**
     * 获取注册时间
     *
     * @return REGISTERED_TIME - 注册时间
     */
    public Date getRegisteredTime() {
        return registeredTime;
    }

    /**
     * 设置注册时间
     *
     * @param registeredTime 注册时间
     */
    public void setRegisteredTime(Date registeredTime) {
        this.registeredTime = registeredTime;
    }

    /**
     * 获取注册IP
     *
     * @return REGISTERED_IP - 注册IP
     */
    public String getRegisteredIp() {
        return registeredIp;
    }

    /**
     * 设置注册IP
     *
     * @param registeredIp 注册IP
     */
    public void setRegisteredIp(String registeredIp) {
        this.registeredIp = registeredIp == null ? null : registeredIp.trim();
    }

    /**
     * 获取更新人
     *
     * @return UPDATE_BY - 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     *
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_DATE - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取备注
     *
     * @return REMARKS - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取是否删除
     *
     * @return DEL_FLAG - 是否删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置是否删除
     *
     * @param delFlag 是否删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}