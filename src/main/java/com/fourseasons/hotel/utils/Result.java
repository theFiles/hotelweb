package com.fourseasons.hotel.utils;

import lombok.Data;

/**
 * @author yuzhi
 */
@Data
public class Result<T> {

    private int status;
    private String msg;
    /**
     * 0 表示登录成功
     * 1 表示密码错误
     * 2 表示账号不存在
     */
    private int state = 0;
    private T data;

    public static Result success(Object obj) {
        Result result =new Result();
        result.setData(obj);
        result.setMsg("success");
        result.setStatus(200);
        return result;
    }
    public static Result error() {
        Result result = new Result();
        return result;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setData(T data) {
        this.data = data;
    }
}
