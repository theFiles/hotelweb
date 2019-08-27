package com.vip.home.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.vip.home.domain.vo.TRoomImageVo;
import lombok.Data;

@Data
public class TRoom {
    private Integer roomId;

    private String roomNum;

    private BigDecimal roomPrice;

    private Date roomCreateTime;

    private Byte roomStatus;

    private Integer roomTypeId;

    private Integer orderId;

    private Integer adminId;

    List<TRoomImageVo> tRoomImageVoList;
}