package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yuzhi
 */
@Data
public class TUser  {
    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String userPassword;

    /**
     *
     */
    private Date userCreateTime;

    /**
     *
     */
    private Byte userStatus;
}

