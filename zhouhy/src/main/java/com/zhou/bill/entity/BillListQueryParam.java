package com.zhou.bill.entity;

import com.zhou.index.comm.util.DateHelper;
import lombok.Data;

/**
 * @Author: zhouhy
 * @Description:
 * @Date: Create in 17:53 2018/9/20
 * @Modified By
 */
@Data
public class BillListQueryParam {

    private int current = 1;

    private int size = 15;

    private String startTime = "" + DateHelper.getYMDStr(0,0,0,1);

    private String endTime = "" + DateHelper.getYMDStr(0,1,0,1);

}
