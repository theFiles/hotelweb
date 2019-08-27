package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.domain.entity.TRoom;
import com.fourseasons.hotel.domain.vo.TRoomTypeVo;
import com.fourseasons.hotel.domain.vo.TRoomVo;
import com.fourseasons.hotel.service.RoomSystemService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author yuzhi
 */
@RestController
@RequestMapping("/api/v2")
public class RoomSystemController {
    @Resource
    RoomSystemService roomsystemService;

    /**
     *按类型查询显示房间信息
     */

    @RequestMapping("/contents")
    public Result getContentData(){
        try {
            List<TRoomTypeVo> tRoomTypeVoList= roomsystemService.getContent();
            return Result.success(tRoomTypeVoList);
        } catch (Exception e) {
            return Result.error();
        }
    }

    /**
     *获取所有房间信息
     */

    @RequestMapping("/all")
    public Result getAllRoomsData(){
        try {
            List<TRoomVo> tRoomVoList= roomsystemService.getAllRooms();
            return Result.success(tRoomVoList);
        } catch (Exception e) {
            return Result.error();
        }
    }

    /**
     * 房间详情页
     */

    @RequestMapping("/details")
    public Result getRoomDeatils(Integer roomId){
        try {
            List<TRoomVo> roomDeatils= roomsystemService.getRoomDeatils(roomId);
            return Result.success(roomDeatils);
        } catch (Exception e) {
            return Result.error();
        }
    }

    /**
     *搜索条件查询房间信息
     */

    @RequestMapping("/search")
    public Result<List<TRoom>> search(String keyword){
        try {
            List<TRoom> search = roomsystemService.search(keyword);
            return Result.success(search);
        } catch (Exception e){
            return Result.error();
        }
    }

}
