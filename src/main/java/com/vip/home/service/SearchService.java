package com.vip.home.service;

import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomVo;

import java.util.List;

public interface SearchService {
    List<TRoomVo> search(int roomId);


}
