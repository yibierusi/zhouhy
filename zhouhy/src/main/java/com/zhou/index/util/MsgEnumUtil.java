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
public enum MsgEnumUtil {
    SUCCESS(0,"成功"),
    ERROR(1,"错误"),
    NO_ALBUMS_CREATED(2,"未创建相册"),
    NO_PHOTO_TO_UPLOAD(3,"未上传图片");

    private Integer code;
    private String msg;

    MsgEnumUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
