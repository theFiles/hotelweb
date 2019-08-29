package com.vip.home.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class TRoomImage {
    private Integer roomImageId;

    private String roomImageUrl;

    private String roomImageDescribe;

    private Date roomImageCreateTime;

    private Byte roomImageOrder;

    private Byte roomImageStatus;

    private Integer roomId;
}