package com.vip.home.controller;

import com.vip.home.domain.entity.TRoomType;
import com.vip.home.domain.vo.TRoomTypeVo;
import com.vip.home.service.IndexService;
import com.vip.home.utils.HomePage;
import com.vip.home.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @Resource
    IndexService indexService;

    @GetMapping("/company")
    public Result getCompanyData(){

        HomePage homePage = indexService.getHomePage();
        try {
            return Result.success(homePage);
        }catch (Exception e){
            return Result.error();
        }
    }

    @GetMapping("/contents")
    public Result getContentDate(){
        try{
            List<TRoomTypeVo> content = indexService.getContent();
            return Result.success(content);
        }catch (Exception e){
            return Result.error();
        }

    }

    @GetMapping("/type")
    public Result getContentType(){
try{ List<TRoomType> roomType = indexService.getRoomType();
    return Result.success(roomType);
}catch (Exception e){
    return Result.error();
}

    }
}
