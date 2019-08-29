package com.vip.home.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class TRoomType {
    private Integer roomTypeId;

    private String roomTypeName;

    private BigDecimal roomTypePrice;

    private String roomTypeDescribe;

    private Date roomTypeCreateTime;

    private Byte roomTypeOrder;


}