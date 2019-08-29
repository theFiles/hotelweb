package com.fourseasons.hotel.mapper;

import com.fourseasons.hotel.domain.entity.TRoomType;
import com.fourseasons.hotel.domain.vo.TRoomTypeVo;

import java.util.List;

/**
 * @author yuzhi
 */
public interface TRoomTypeMapper {
    List<TRoomTypeVo> findByRoomTypeId();

    List<TRoomType> findTRoomType();
}
