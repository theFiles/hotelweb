package com.fourseasons.hotel.utils;

import com.fourseasons.hotel.domain.entity.TCompany;
import com.fourseasons.hotel.domain.entity.TRoom;
import com.fourseasons.hotel.domain.entity.TRoomType;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yuzhi
 */

@Data
public class CateBean implements Serializable {
    List<TRoomType> tRoomType1List;
    List<TCompany> tCompanyList;
    List<TRoom> tRoomOrderList;

}
