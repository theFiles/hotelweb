package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    /**
     * 登录
     * @param userName      用户名
     * @param passWord      密码
     * @return              Result结果对象
     */
    @GetMapping("/Login")
    public Result login(String userName, String passWord){
        return null;
    }

    /**
     * 登出
     * @return          退出登录
     */
    @GetMapping("/Logout")
    public Result logout(){
        return null;
    }

}
