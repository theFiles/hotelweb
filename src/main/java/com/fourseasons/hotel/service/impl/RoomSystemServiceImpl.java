package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.TRoom;
import com.fourseasons.hotel.domain.vo.TRoomTypeVo;
import com.fourseasons.hotel.domain.vo.TRoomVo;
import com.fourseasons.hotel.mapper.TRoomMapper;
import com.fourseasons.hotel.mapper.TRoomTypeMapper;
import com.fourseasons.hotel.service.RoomSystemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuzhi
 */
@Service
public class RoomSystemServiceImpl implements RoomSystemService {
    @Resource
    TRoomTypeMapper tRoomTypeMapper;
    @Resource
    TRoomMapper tRoomMapper;

    @Override
    public List<TRoomTypeVo> getContent(){
        List<TRoomTypeVo> tRoomTypeVoList = tRoomTypeMapper.findByRoomTypeId();
        return  tRoomTypeVoList;

    }

    @Override
    public List<TRoomVo> getAllRooms() {
        List<TRoomVo> tRoomVoList = tRoomMapper.findAllRooms();
        return tRoomVoList;
    }


    @Override
    public List<TRoomVo> getRoomDeatils(Integer roomId) {
        List<TRoomVo> getRoomDeatils = tRoomMapper.findByroomId(roomId);
        return getRoomDeatils;
    }

    @Override
    public List<TRoom> search(String keyword) {
        return tRoomMapper.findByKeyword(keyword);
    }


}
