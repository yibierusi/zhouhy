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
@TableName("sys_role")
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
	private String id;
    /**
     * 角色名字
     */
	@TableField("role_name")
	private String roleName;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
