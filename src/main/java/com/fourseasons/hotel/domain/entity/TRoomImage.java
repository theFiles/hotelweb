package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yuzhi
 */
@Data
public class TRoomImage {
    /**
     *
     */
    private Integer roomImageId;

    /**
     *
     */
    private String roomImageUrl;

    /**
     *
     */
    private String roomImageDescribe;

    /**
     *
     */
    private Date roomImageCreateTime;

    /**
     *
     */
    private Byte roomImageOrder;

    /**
     *
     */
    private Byte roomImageStatus;

    /**
     *
     */
    private Integer roomId;
}

