package com.fourseasons.hotel.domain.vo;

import com.fourseasons.hotel.domain.entity.TRoom;
import com.fourseasons.hotel.domain.entity.TRoomType;
import lombok.Data;

import java.util.List;


/**
 * @author yuzhi
 */

@Data
public class TRoomVo extends TRoom {
    List<TRoomType> tRoomTypeList;
}
