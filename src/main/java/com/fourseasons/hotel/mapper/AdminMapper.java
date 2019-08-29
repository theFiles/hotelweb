package com.fourseasons.hotel.mapper;

import com.fourseasons.hotel.domain.entity.Admin;
import com.fourseasons.hotel.domain.vo.AdminVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     * 通过
     * @param name      用户名查询
     * @return          获取管理员对象
     */
    AdminVo findAdminByName(@Param("name") String name,@Param("status") int status);

    /**
     * 通过id修改登录时间
     * @param aid       管理员id
     * @param time      日期字符串
     * @return          影响的数据行数
     */
    int updateLoginTimeById(@Param("aid") int aid,@Param("time") String time);

    /**
     * 新增一个管理员
     * @param admin     管理员对象
     * @return          影响的数据行数
     */
    int insertAdmin(@Param("admin") Admin admin);

    /**
     * 删除管理员
     * @param aid       管理员id
     * @return          影响的数据行数
     */
    int deleteAdmin(@Param("aid") int aid);

    /**
     * 获取多个管理员
     * @param search        查询关键字
     * @param num           起始查询位置
     * @param size          查询量
     * @return              多个管理员对象
     */
    List<Admin> findAdminAll(
            @Param("search") String search,
            @Param("num") int num,
            @Param("size") int size
    );
}
