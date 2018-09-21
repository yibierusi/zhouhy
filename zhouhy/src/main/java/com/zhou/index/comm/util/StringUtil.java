package com.zhou.index.comm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-15 11:40
 **/
public class StringUtil {

    public static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }
    public static String removeFirstChar(String str) {
        return str.substring(1, str.length());
    }
    public static String removeFirstAndLastChar(String str) {
        str = removeLastChar(str);
        return removeFirstChar(str);
    }

}
