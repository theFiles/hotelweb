package com.fourseasons.hotel.domain.vo;

import com.fourseasons.hotel.domain.entity.TRoom;
import com.fourseasons.hotel.domain.entity.TRoomType;
import lombok.Data;

import java.util.List;

/**
 * @author yuzhi
 */
@Data
public class TRoomTypeVo extends TRoomType {
    List<TRoom> tRoomList;
}
