package com.zhou.index.entity;

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
	private Integer state;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
