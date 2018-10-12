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
public class DateHelper {

    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取年-月-日
     */
    public static String getYMDStr(int y, int m, int d,int setDay) {
        String str = "" + getYMD(y,m,d,setDay);
        str = str.substring(0,4) + "-" + str.substring(4,6) + "-" + str.substring(6,8);
        return str;
    }

    /**
     * 获取年月日
     */
    public static int getYMD(int y, int m, int d,int setDay) {
        Calendar cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR) + y;
        int month = cale.get(Calendar.MONTH) + 1 + m;
        if (month == 13){
            month = 01;
            year++;
        }
        int day = cale.get(Calendar.DATE) + d;
        if (setDay != 0){
            day = setDay;
        }
        return year * 10000 + month * 100 + day;
    }


    /**
     * 获取1-31的数组；
     */
    public static int[] get31Array() {
        int[] array = new int[31];
        for (int i = 0; i < 31; i++) {
            array[i] = i+1;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(getYMDStr(0, 0, 0,2));
    }
}
