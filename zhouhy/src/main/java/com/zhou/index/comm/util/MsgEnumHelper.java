package com.zhou.index.comm.util;

/**
 * Title：
 * Description：
 *
 * @author: zhouhy
 * @create 2017-11-13 14:51
 **/
public enum MsgEnumHelper {
    SUCCESS(0,"成功"),
    ERROR(1,"错误"),
    RESULT_SET_NOT_EXIST(501,"结果集不存在"),
    STATEMENT_EXE_FAILED(502,"SQL语句执行失败"),
    NO_ALBUMS_CREATED(2,"未创建相册"),
    NO_PHOTO_TO_UPLOAD(3,"未上传图片");

    private Integer code;
    private String msg;

    MsgEnumHelper(Integer code, String msg) {
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
