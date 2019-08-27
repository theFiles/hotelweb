package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yuzhi
 */
@Data
public class TOrder {
    /**
     *
     */
    private Integer orderId;

    /**
     *
     */
    private String orderCode;

    /**
     *
     */
    private Date orderCreateTime;

    /**
     *
     */
    private Date orderRoomstart;

    /**
     *
     */
    private Date orderRoomend;

    /**
     *
     */
    private BigDecimal orderPrice;

    /**
     *
     */
    private Byte orderStatus;

    /**
     *
     */
    private Integer userId;
}

