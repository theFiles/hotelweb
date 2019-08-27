package com.fourseasons.hotel.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userPassword;
    private Date userLastLogin;
    private Date userCreateTime;
    private Integer userStatus;
}
