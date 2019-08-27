package com.fourseasons.hotel.service;

import com.fourseasons.hotel.domain.entity.User;

/**
 * token业务操作
 * @author lidaye
 */
public interface TokenService {
    /**
     * 通过id换取获取token
     * @param id        id
     * @return          token字符串
     */
    String getToken(int id);

    /**
     * 通过用户名检测token
     * @param name      用户名
     * @param token     token字符串
     * @return          true token有效
     */
    boolean ckToken(String name,String token);
}
