package com.zhou.bill.entity;

import com.zhou.index.comm.util.DateUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:53 2018/9/20
 * @Modified By
 */
@Data
public class BillListQueryParam {

    private int current = 1;

    private int size = 15;

    private int startTime = DateUtil.getYMD(0,0,0,1);

    private int endTime = DateUtil.getYMD(0,1,0,1);


}
