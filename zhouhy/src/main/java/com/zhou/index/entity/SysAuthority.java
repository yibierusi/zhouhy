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
@TableName("sys_authority")
public class SysAuthority extends Model<SysAuthority> {

    private static final long serialVersionUID = 1L;

    /**
     * 许可ID
     */
	private String id;
    /**
     * 权限名字
     */
	@TableField("authority_name")
	private String authorityName;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
