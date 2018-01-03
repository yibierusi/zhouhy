package com.zhou.index.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-15 11:40
 **/
public class DateUtil {

    public static String dateToString(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
