package com.fourseasons.hotel.utils.consts;

/**
 * 结果对象状态码
 * @author lidaye
 */
public class ResultCode {
    /**
     * 成功
     */
    public static final int SUCCESS_CODE = 200;

    /**
     * 无权限
     */
    public static final int UNROOT_CODE = 401;

    /**
     * 无法读取
     */
    public static final int UNREAD_CODE = 403;

    /**
     * 无请求对象
     */
    public static final int LOSS_CODE = 404;

    /**
     * 失败
     */
    public static final int ERROR_CODE = 500;
}
