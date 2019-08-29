package com.vip.home.service;

import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomTypeVo;
import com.vip.home.utils.HomePage;

import java.util.List;

/**
 * @author Administrator
 */
public interface IndexService {
    HomePage getHomePage();

    List<TRoomTypeVo> getContent();

    List<TRoomType> getRoomType();
}
