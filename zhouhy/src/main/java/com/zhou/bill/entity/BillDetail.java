package com.zhou.bill.entity;

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
 * @since 2018-09-20
 */
@TableName("bill_detail")
@Data
public class BillDetail extends Model<BillDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 账单明细ID
     */
	private String id;
    /**
     * 类型：1支出  2  收入
     */
	private Integer type;
    /**
     * 金额
     */
	private Double money = 0d;
    /**
     * 账单ID
     */
	@TableField("bill_id")
	private String billId;
    /**
     * 标签ID
     */
	@TableField("bill_tag_ids")
	private String billTagIds = null;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
