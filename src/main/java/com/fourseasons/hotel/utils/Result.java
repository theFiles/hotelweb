package com.fourseasons.hotel.utils;

import lombok.Data;

/**
 * @author yuzhi
 */
@Data
public class Result<T> {
    private int status;
    private String msg;
    private T data;

    public static Result success(Object obj) {
        Result result =new Result();
        result.setData(obj);
        System.out.println(1113);
        result.setMsg("success");
        result.setStatus(200);
        return result;
    }
    public static Result error() {
        Result result = new Result();
        System.out.println(1115);
        return result;
    }



}
