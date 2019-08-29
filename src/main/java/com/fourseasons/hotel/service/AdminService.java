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

    /**
     * 登出
     * @param id        管理员id
     * @return          结果对象
     */
    Result logout(int id);

    /**
     * 创建管理员
     * @param name      用户名
     * @param pwd       密码
     * @return          结果对象
     */
    Result addAdmin(String name,String pwd);

    /**
     * 删除管理员
     * @param id        管理员id
     * @return          结果对象
     */
    Result delAdmin(int id);

    /**
     * 获取一个用户信息
     * @param uid       用户id
     * @return          结果对象
     */
    Result getUserInfo(int uid);

    /**
     * 获取用户列表
     * @param search        查询关键字
     * @param page          页码
     * @return              结果对象
     */
    Result getUsers(String search,int page);

    /**
     * 获取管理员列表
     * @param search        查询关键字
     * @param page          页码
     * @return              结果对象
     */
    Result getAdmins(String search,int page);

    /**
     * 获取房间列表
     * @param search        查询关键字
     * @param page          页码
     * @return              结果对象
     */
    Result getRooms(String search,int page);

    /**
     * 获取订单列表
     * @param search        查询关键字
     * @param page          页码
     * @return              结果对象
     */
    Result getOrders(String search,int page);
}
