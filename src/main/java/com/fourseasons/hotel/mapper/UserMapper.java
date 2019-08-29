package com.fourseasons.hotel.mapper;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * 通过id获取用户信息
     * @param uid       用户id
     * @return          用户对象
     */
    User findUserById(@Param("uid") int uid);

    /**
     * 通过名称获取用户信息
     * @param name 用户名
     * @return 用户对象
     */
    UserVo findUserByName(@Param("name") String name,@Param("status") int status);

    /**
     * 通过id修改登录时间
     * @param uid       用户id
     * @param time      日期字符串
     * @return          修改数据行数
     */
    int updateLoginTimeById(@Param("uid") int uid,@Param("time") String time);

    /**
     * 通过用户对象新增一个用户
     * @param user      用户对象
     * @return          操作的数据数
     */
    int insertUser(@Param("user") User user);

    /**
     * 批量查询用户
     * @param search        查询条件
     * @param num           起始数量
     * @param size          显示数量
     * @return              多个用户对象
     */
    List<User> findUsers(
            @Param("search") String search,
            @Param("num") int num,
            @Param("size") int size
    );
}
