package com.vip.home.controller;


import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomVo;
import com.vip.home.service.SearchService;
import com.vip.home.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    @Resource
    SearchService searchService;

    @GetMapping("/search")
    public Result<List<TRoomVo>> search(int roomId){
        try{
            List<TRoomVo> search = searchService.search(roomId);
            return Result.success(search);
        }catch (Exception e){
            return  Result.error();
        }
    }


}
