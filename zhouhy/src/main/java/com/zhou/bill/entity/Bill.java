package com.zhou.bill.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.Data;

/**
 * <p>
 * 账单流水实体
 * </p>
 *
 * @author zhouhy
 * @since 2018-09-20
 */
@Data
public class Bill extends Model<Bill> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增长ID
     */
	private String id;
    /**
     * 时间，20180920
     */
	private Integer date;
    /**
     * 支出
     */
	private Double paid;
	/**
	 * 最大单笔支出
	 */
	@TableField("max_paid")
	private Double maxPaid;
	/**
	 * 最大单笔支出说明
	 */
	@TableField("max_paid_explain")
	private String maxPaidExplain;
    /**
     * 收入
     */
	private Double income;
	/**
	 * 最大单笔支出
	 */
	@TableField("max_income")
	private Double maxIncome;
	/**
	 * 最大单笔支出说明
	 */
	@TableField("max_income_explain")
	private String maxIncomeExplain;
	/**
	 * 状态  1：正常  2：异常  3：警告
	 */
	private int status;
    /**
     * 用户ID
     */
	@TableField("sys_user_id")
	private String sysUserId;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
