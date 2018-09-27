package com.zhou.index.comm.util;

import org.apache.commons.lang.StringUtils;

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
public class StringHelper {

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

    /**
     * @Author: zhouhy
     * @Description:移除特殊符号
     * @Date: 17:40 2018/7/19
     * @params: [str]
     * @returns: java.lang.String
     */
    public static String removeSymbol(String str) {
        if (StringUtils.isEmpty(str)) {
            return "";
        }
        str = str.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+", "");
        return str;
    }

    /**
     * 字符串二合一
     */
    public static String mergeStr(String str1, String str2, String split) {
        if (StringUtils.isEmpty(str1)) {
            return str2;
        }
        if (StringUtils.isEmpty(str2)) {
            return str1;
        }
        return str1 + split + str2;
    }

}
