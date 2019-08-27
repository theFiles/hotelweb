package com.fourseasons.hotel.service;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.utils.Token;
import com.fourseasons.hotel.utils.consts.DataBaseConst;

import java.text.SimpleDateFormat;

/**
 * token业务操作
 * @author lidaye
 */
public interface TokenService {

    /**
     * 通过id修改最后登录时间
     * @param id            用户id
     * @param format        格式化时间字符串
     * @return              影响数据行数
     */
    int resetLastTime(int id, String format);

    /**
     * 通过id换取获取token
     * @param id        id
     * @return          token字符串
     */
    default String getToken(int id){
        String token = null;

        // 当前时间
        long time = System.currentTimeMillis();
        // 转换成数据库识别格式
        String format = new SimpleDateFormat(DataBaseConst.DATE_FORMAT).format(time);
        // 修改字段值
        int res = resetLastTime(id, format);
        // 生成token
        if(res > 0){token = Token.enToken(id, time);}

        return token;
    }

    /**
     * 通过用户名检测token
     * @param name      用户名
     * @param token     token字符串
     * @return          true token有效
     */
    boolean ckToken(String name,String token);
}
