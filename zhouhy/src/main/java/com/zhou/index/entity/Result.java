package com.zhou.index.entity;

import com.zhou.index.comm.util.MsgEnumUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhouhy
 * @Description: 返回对象
 * @Date: 14:06 2018/8/23
 */
@Data
public class Result {
    private Integer code;
    private String msg;
    private Map<String, Object> obj = new HashMap<>();

    public Result() {
        super();
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result ok() {
        return new Result(200, "success");
    }

    public static Result error() {
        return new Result(500, "error");
    }

    public static Result create(MsgEnumUtil me) {
        return new Result(me.code(), me.msg());
    }

    public Result put(String key, Object value) {
        this.obj.put(key, value);
        return this;
    }

}
