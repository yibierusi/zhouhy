package com.zhou.index.comm.constant;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 9:56 2018/9/21
 * @Modified By
 */
public enum BillDetailType {
    PAID(1,"支出"),
    INCOME(2,"收入");

    private int k;

    private String v;

    BillDetailType(int k, String v) {
        this.k = k;
        this.v = v;
    }
}
