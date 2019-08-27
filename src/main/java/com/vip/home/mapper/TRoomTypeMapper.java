package com.vip.home.mapper;

import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomTypeVo;

import java.util.List;

/**
 * @author Administrator
 */
public interface TRoomTypeMapper {
    List<TRoomTypeVo> findAll();
}