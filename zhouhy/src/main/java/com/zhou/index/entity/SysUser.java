package com.zhou.index.entity;

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
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	private String id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 密码
     */
	private String password;
    /**
     * 网名
     */
	private String nickname;
    /**
     * 性别
     */
	private String sex;
    /**
     * 生日
     */
	@TableField("birth_date")
	private Date birthDate;
    /**
     * 头像
     */
	private String ico;
    /**
     * 签名
     */
	private String signature;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 手机
     */
	private String phone;
    /**
     * 电话
     */
	private String mobile;
    /**
     * 用户类型
     */
	@TableField("user_type")
	private String userType;
    /**
     * 用户状态
     */
	@TableField("user_state")
	private String userState;
	@TableField("login_time")
	private Date loginTime;
    /**
     * 登录ip
     */
	@TableField("login_ip")
	private String loginIp;
    /**
     * 注册时间
     */
	@TableField("registered_time")
	private Date registeredTime;
    /**
     * 注册ip
     */
	@TableField("registered_ip")
	private String registeredIp;
	@TableField("update_by")
	private String updateBy;
    /**
     * 更新时间
     */
	@TableField("update_date")
	private Date updateDate;
    /**
     * 备注
     */
	private String remarks;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}

	public String getRegisteredIp() {
		return registeredIp;
	}

	public void setRegisteredIp(String registeredIp) {
		this.registeredIp = registeredIp;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
		return "SysUser{" +
			"id=" + id +
			", username=" + username +
			", password=" + password +
			", nickname=" + nickname +
			", sex=" + sex +
			", birthDate=" + birthDate +
			", ico=" + ico +
			", signature=" + signature +
			", email=" + email +
			", phone=" + phone +
			", mobile=" + mobile +
			", userType=" + userType +
			", userState=" + userState +
			", loginTime=" + loginTime +
			", loginIp=" + loginIp +
			", registeredTime=" + registeredTime +
			", registeredIp=" + registeredIp +
			", updateBy=" + updateBy +
			", updateDate=" + updateDate +
			", remarks=" + remarks +
			", delFlag=" + delFlag +
			"}";
	}
}
