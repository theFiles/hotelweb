package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuzhi
 */
@RestController
@RequestMapping("/account/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login", params = {"name", "pwd"})
    public Result login(String name, String pwd) {
        Result result = userService.login(name, pwd);
        return result;
    }

}
