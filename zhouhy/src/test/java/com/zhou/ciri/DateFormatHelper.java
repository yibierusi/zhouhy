package com.zhou.ciri;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:25 2018/7/19
 * @Modified By
 */
public class DateFormatHelper {

    private static String fullFormat = "yyyyMMddHHmmss";

    private static String ymdFormat = "yyyyMMdd";

    /**
     *  @Author: zhouhy
     *  @Description: 根据给出的时间格式 将字符串转化为时间格式
     *  @Date: 17:29 2018/7/19
     *  @params: [dateString, pattern]
     *  @returns: java.util.Date
     */
    public static Date stringToDate(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
        }
        return date;
    }

}
