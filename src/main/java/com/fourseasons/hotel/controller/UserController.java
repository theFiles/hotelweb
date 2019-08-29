package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lidaye
 */
@RestController
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 登录
     * @param name          用户名
     * @param pwd           密码
     * @return              Result结果对象
     */
    @GetMapping(value = "/Login", params = {"name","pwd"})
    public Result login(String name,String pwd){
        return userService.login(name, pwd);
    }

    /**
     * 注册
     * @param user      注册信息对象
     * @return          Result结果对象
     */
    @PostMapping("/Registered")
    public Result registered(@RequestBody User user){
        return userService.registered(user);
    }

    /**
     * 登出
     * @return          退出登录
     */
    @GetMapping("/Logout")
    public Result logout(@RequestParam int id){
        return userService.logout(id);
    }

    /**
     * 用户详情
     * @param id        用户id
     * @return          有用户信息的结果对象
     */
    @GetMapping("/UserInfo")
    public Result userInfo(@RequestParam int id){
        return userService.getUserInfo(id);
    }
}
