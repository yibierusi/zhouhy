package com.zhou.index.entity;

import lombok.Data;

/**
 * 作者： zhouhy
 * 时间：2018/1/5.
 * 说明：返回对象
 */

@Data
public class Result {
    private Integer code;
    private String msg;
    private Object obj;

    public Result() {
        super();
    }

    public Result(Integer code,String msg ,Object obj) {
        this.code = code;
        this.msg = msg;
        this.obj = obj;
    }

}
