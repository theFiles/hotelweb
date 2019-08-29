package com.vip.home.utils;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class Result <T>{
    private int status;
    private String msg;
    private T data;

    public static Result success(Object obj){
        Result result = new Result();
        result.setData(obj);
        result.setMsg("success");
        result.setStatus(200);
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setMsg("error");
        result.setStatus(404);
        return result;
    }
}
