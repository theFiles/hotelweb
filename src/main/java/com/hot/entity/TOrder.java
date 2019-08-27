package com.hot.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TOrder {
    private Integer orderId;

    private String orderCode;

    private Date orderCreateTime;

    private Date orderRoomstart;

    private Date orderRoomend;

    private BigDecimal orderPrice;

    private Byte orderStatus;

    private Integer userId;

    private Integer num;

    private TRoom tRoom;

    private Integer roomId;

}