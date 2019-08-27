package com.hot.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TUser {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Date userCreateTime;

    private Byte userStatus;

    private List<TOrder> tOrders;


}