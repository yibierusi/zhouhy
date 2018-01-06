package com.zhou.index.util;

import com.zhou.blog.controller.BlogController;
import com.zhou.photo.controller.PhotoController;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-13 14:51
 **/
public enum EnumUtil {
    BLOG_PATH("1", "./src/main/resources/public/upload/blog/"),
    BLOG_CLASS_PATH("2", BlogController.class.getResource("/").getPath()+"public/upload/blog/"),
    PHOTOT_PATH("3", "./src/main/resources/public/upload/photo/"),
    PHOTO_CLASS_PATH("4", PhotoController.class.getResource("/").getPath()+"public/upload/photo/"),

    OBJECT_IP("127","127.0.0.1"),
    OBJECT_PROT("80","80"),

    DATE_FULL_FORMAT("99", "yyyyMMddHHmmss");

    private String value;
    private String text;

    EnumUtil(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String value() {
        return value;
    }

    public String text() {
        return text;
    }
}
