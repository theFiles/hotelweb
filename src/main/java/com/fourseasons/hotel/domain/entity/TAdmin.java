package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author yuzhi
 */
@Data
public class TAdmin {
    /**
     *
     */
    private Integer adminId;

    /**
     *
     */
    private String adminName;

    /**
     *
     */
    private String adminPassword;

    /**
     *
     */
    private Date adminCreateTime;

    /**
     *
     */
    private Byte adminStatus;
}

