package com.fourseasons.hotel.mapper;


import com.fourseasons.hotel.domain.entity.TAdmin;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuzhi
 */
public interface TAdminMapper {
    TAdmin findTAdminByName(@Param("name") String name, @Param("pwd") String pwd);
}
