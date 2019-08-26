package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.domain.vo.UserVo;
import com.fourseasons.hotel.mapper.UserMapper;
import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.Result;
import com.fourseasons.hotel.utils.Token;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(String userName, String passWord) {
        UserVo userByName = userMapper.findUserByName(userName);

        // 如果找不到，返回数据错误
        if(userByName == null){return Result.loss();}

        if(passWord.equals(userByName.getUserPassword())){
            Integer userId = userByName.getUserId();
            long time = System.currentTimeMillis();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
            userMapper.updateLoginTimeById(userId,format);
            userByName.setToken(Token.enToken(userByName.getUserId(), time));
        }

        return passWord.equals(userByName.getUserPassword())?
                Result.success(userByName):
                Result.error();
    }

    @Override
    public Result logOut() {
        return null;
    }

    @Override
    public Result registered(User user) {
        int num = userMapper.insertUser(user);
        if(num > 0){
            return Result.success(userMapper);
        }
        else{
            return Result.error();
        }
    }
}
