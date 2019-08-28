package com.fourseasons.hotel.mapper;


import com.fourseasons.hotel.domain.entity.TRoom;
import com.fourseasons.hotel.domain.vo.TRoomVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuzhi
 */

public interface TRoomMapper {
    List<TRoomVo> findAllRooms();

    List<TRoomVo> findByroomId(@Param("roomId") Integer roomId);

    List<TRoom> findByKeyword(@Param("keyword") String keyword);
<<<<<<< Updated upstream
=======

    List<TRoom> findTRoomOrder();
>>>>>>> Stashed changes
}
