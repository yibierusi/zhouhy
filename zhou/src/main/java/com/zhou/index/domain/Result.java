package com.zhou.index.domain;
/**
 * 作者： zhouhy
 * 时间：2018/1/5.
 * 说明：返回对象
 */

public class Result {
    private Integer code;
    private String msg;
    private Object obj;

    public Result() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
