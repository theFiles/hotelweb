package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yuzhi
 */
@Data
public class TRoom {
    /**
     *
     */
    private Integer roomId;

    /**
     *
     */
    private String roomNum;

    /**
     *
     */
    private BigDecimal roomPrice;

    /**
     *
     */
    private Date roomCreateTime;

    /**
     *
     */
    private Byte roomStatus;

    /**
     *
     */
    private Integer roomTypeId;

    /**
     *
     */
    private Integer orderId;

    /**
     *
     */
    private Integer adminId;
}

