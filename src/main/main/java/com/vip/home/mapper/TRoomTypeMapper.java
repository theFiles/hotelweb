package com.vip.home.mapper;

import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
public interface TRoomTypeMapper {
    List<TRoomTypeVo> findAll();

    List<TRoomType> findByType();
}