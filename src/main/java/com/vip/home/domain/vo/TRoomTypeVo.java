package com.vip.home.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class TRoomTypeVo {
    private Integer roomTypeId;

    private String roomTypeName;

    private BigDecimal roomTypePrice;

    private String roomTypeDescribe;

    private Byte roomTypeOrder;

    List<TRoomVo> tRoomVos;
}
