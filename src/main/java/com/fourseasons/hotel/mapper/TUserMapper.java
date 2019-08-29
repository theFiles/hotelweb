package com.fourseasons.hotel.mapper;


import com.fourseasons.hotel.domain.entity.TUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuzhi
 */
public interface TUserMapper {
    TUser findTUserByName(@Param("name") String userName, @Param("pwd") String userPassword);
}
