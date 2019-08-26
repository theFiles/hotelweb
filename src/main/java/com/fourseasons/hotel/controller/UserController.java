package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     * @param userName      用户名
     * @param passWord      密码
     * @return              Result结果对象
     */
    @GetMapping(value = "/Login", params = {"userName","passWord"})
    public Result login(String userName,String passWord){
        return userService.login(userName, passWord);
    }

    /**
     * 注册
     * @param user      注册信息对象
     * @return          Result结果对象
     */
    @PostMapping("/Registered")
                    public Result registered(@RequestBody User user){
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
