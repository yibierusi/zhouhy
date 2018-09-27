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

    public static void main(String[] args) {
        System.out.println(getYMD(0, 0, 0,2));
    }
}
