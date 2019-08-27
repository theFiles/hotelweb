package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yuzhi
 */
@Data
public class TRoomType {
    /**
     *
     */
    private Integer roomTypeId;

    /**
     *
     */
    private String roomTypeName;

    /**
     *
     */
    private BigDecimal roomTypePrice;

    /**
     *
     */
    private String roomTypeDescribe;

    /**
     *
     */
    private Date roomTypeCreateTime;

    /**
     *
     */
    private Byte roomTypeOrder;

    /**
     *
     */
    private Byte roomTypeStatus;
}

