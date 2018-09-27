package com.zhou.index.comm.util;

import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Auther: zhouhy
 * @Description:
 * @Date: Create in 17:58 2018/7/19
 * @Modified By
 */
public class CollectionHelper {

    private static final String symbol = ",";

    /**
     * @Author: zhouhy
     * @Description: list集合转String 符号分隔
     * @Date: 17:59 2018/7/19
     * @params: [list]
     * @returns: java.lang.String
     */
    public static String listToString(List list) {
        if (list == null || list.size() == 0)
            return null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).toString());
            sb.append(symbol);
        }
        return StringHelper.removeLastChar(sb.toString());

    }

    /**
     * @Author: zhouhy
     * @Description: map集合的value转String 符号分隔
     * @Date: 17:59 2018/7/19
     * @params: [map]
     * @returns: java.lang.String
     */
    public static String mapToString(Map<Integer, String> maps) {
        if (maps == null)
            return null;
        StringBuffer sb = new StringBuffer();
        for (Integer key : maps.keySet()) {
            sb.append(maps.get(key) + ",");
        }
        if (StringUtils.isEmpty(sb.toString()))
            return "";
        return sb.toString().substring(0, sb.toString().length() - 1);
    }


}
