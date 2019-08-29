package com.vip.home.domain.vo;

import lombok.Data;

import java.util.Date;
@Data
public class TRoomImageVo {
    private Integer roomImageId;

    private String roomImageUrl;

    private String roomImageDescribe;


    private Byte roomImageOrder;


    private Integer roomId;
}
