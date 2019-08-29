package com.vip.home.domain.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class TRoomVo {
    private Integer roomId;

    private String roomNum;

    private BigDecimal roomPrice;

    private Integer roomTypeId;

    List<TRoomImageVo> tRoomImageVos;
}
