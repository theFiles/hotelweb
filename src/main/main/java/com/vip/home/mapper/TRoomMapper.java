package com.vip.home.mapper;

import com.vip.home.domain.entity.TRoom;
import com.vip.home.domain.vo.TRoomImageVo;
import com.vip.home.domain.vo.TRoomVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Administrator
 */
public interface TRoomMapper {
        List<TRoomVo> findByRoomId(@Param("roomId") int roomId);
}