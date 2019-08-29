package com.vip.home.utils;

import com.vip.home.domain.entity.TCompany;
import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomTypeVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class HomePage implements Serializable {
    List<TCompany> tCompanies;

    List<TRoomTypeVo> tRoomTypeVos;


    List <TRoomType> tRoomTypes;
}
