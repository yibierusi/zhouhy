package com.zhou.index.entity;

import java.io.Serializable;

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
 * @since 2018-11-12
 */
@Data
@TableName("sys_role_authority")
public class SysRoleAuthority extends Model<SysRoleAuthority> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色-权限关联表ID
     */
	private String id;
    /**
     * 角色ID
     */
	@TableField("role_id")
	private String roleId;
    /**
     * 权限ID
     */
	@TableField("authority_id")
	private String authorityId;
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
