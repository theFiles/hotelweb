package com.fourseasons.hotel.utils;

import com.fourseasons.hotel.utils.consts.ResultCode;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果对象
 * @author lidaye
 */
@Data
public class Result implements Serializable {
    private Integer code;
    private Object data;

    /**
     * 成功返回
     * @param res   内容
     * @return      结果对象（SUCCESS_CODE）
     */
    public static Result success(Object res){
        return newResult(res,ResultCode.SUCCESS_CODE);
    }

    /**
     * 错误返回
     * @return      结果对象（ERROR_CODE）
     */
    public static Result error(){
        return newResult(null,ResultCode.ERROR_CODE);
    }

    /**
     * 结果丢失
     * @return      结果对象（LOSS_CODE）
     */
    public static Result loss(){
        return newResult(null,ResultCode.LOSS_CODE);
    }

    /**
     * 无权限
     * @return      结果对象（UNROOT_CODE）
     */
    public static Result root(){
        return newResult(null,ResultCode.UNROOT_CODE);
    }

    /**
     * 获取结果集对象
     * @param res       结果内容
     * @param code      结果状态码
     * @return          结果对象
     */
    private static Result newResult(Object res,int code){
        Result result = new Result();
        result.setCode(code);
        result.setData(res);
        return result;
    }
}
