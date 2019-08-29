package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.TUser;
import com.fourseasons.hotel.mapper.TUserMapper;
import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuzhi
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    TUserMapper tUserMapper;

    @Override
    public Result login(String name, String pwd) {
        Result result =new Result();
        TUser tUser = tUserMapper.findTUserByName(name,pwd);
        if (tUser != null){
            // 判断密码是否一致
            if (tUser.getUserPassword().equals(pwd)) {
                // 表示登录成功
                result.setState(0);
                // 将tUser对象设置到result
                result.setData(tUser);
            }else{
                // 表示密码错误
                result.setState(1);
            }
        }else {
            // 表示用户名不存在
            result.setState(2);
        }
        return result;
    }
}
