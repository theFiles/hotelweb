package com.fourseasons.hotel.service;

import com.fourseasons.hotel.domain.entity.Admin;
import com.fourseasons.hotel.utils.Result;

public interface AdminService {
    /**
     * 管理员登录
     * @param name      用户名
     * @param pwd       密码
     * @return          结果对象
     */
    Result login(String name, String pwd);
    Result logout(int id);
    Result addAdmin(Admin admin);
    Result delAdmin(int id);
    Result getUsers(String search,int page);
    Result getRooms(String search,int page);
    Result getOrders(String search,int page);
}
