package com.fourseasons.hotel.service;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.utils.Result;

public interface UserService {
    /**
     * 登录
     * @param userName      用户名
     * @param passWord      密码
     * @return              结果对象
     */
    Result login(String userName,String passWord);

    /**
     * 登出
     * @param id        用户id
     * @return          结果对象
     */
    Result logout(int id);

    /**
     * 注册
     * @param user      用户对象
     * @return          结果对象
     */
    Result registered(User user);

    /**
     * 获取用户详情
     * @param uid       用户id
     * @return          结果对象
     */
    Result getUserInfo(int uid);
}
