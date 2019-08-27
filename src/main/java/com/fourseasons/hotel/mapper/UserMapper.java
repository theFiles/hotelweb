package com.fourseasons.hotel.mapper;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.domain.vo.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 通过名称获取用户信息
     *
     * @param name 用户名
     * @return 用户对象
     */
    UserVo findUserByName(@Param("name") String name);

    /**
     * 通过id修改登录时间
     */
    int updateLoginTimeById(@Param("uid") int uid,@Param("time") String time);

    /**
     * 通过用户对象新增一个用户
     * @param user      用户对象
     * @return          操作的数据数
     */
    int insertUser(@Param("user") User user);
}
