package com.vip.home.service.impl;

import com.vip.home.domain.vo.TRoomVo;
import com.vip.home.mapper.TRoomMapper;
import com.vip.home.service.SearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SearchServiceImpl implements SearchService {
    @Resource
    TRoomMapper tRoomMapper;

    @Override
    public List<TRoomVo> search(int roomId) {
       return tRoomMapper.findByRoomId(roomId);

    }
}
