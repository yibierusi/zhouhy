package com.zhou.bill.entity;

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
 * @since 2018-09-20
 */
@Data
@TableName("bill_tag")
public class BillTag extends Model<BillTag> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
	private String id;
    /**
     * 标签名字
     */
	private String name;
    /**
     * 标签说明
     */
	private String explain;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;

	/**
	 * 用户id
	 * @return
	 */
	@TableField("sys_user_id")
	private Date sysUserId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
