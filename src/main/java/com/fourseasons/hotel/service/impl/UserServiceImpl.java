package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.domain.vo.UserVo;
import com.fourseasons.hotel.mapper.UserMapper;
import com.fourseasons.hotel.service.TokenService;
import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.Result;
import com.fourseasons.hotel.utils.Token;
import com.fourseasons.hotel.utils.consts.DataBaseConst;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService,TokenService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(String userName, String passWord) {
        UserVo userByName = userMapper.findUserByName(userName);

        // 如果找不到，返回数据错误
        if(userByName == null){return Result.loss();}

        if(passWord.equals(userByName.getUserPassword())){
            // 设置token
            userByName.setToken(getToken(userByName.getUserId()));
            return Result.success(userByName);
        }
        else{
            return Result.error();
        }

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

    @Override
    public String getToken(int uid) {
        String token = null;
        // 当前时间
        long time = System.currentTimeMillis();
        // 转换成数据库识别格式
        String format = new SimpleDateFormat(DataBaseConst.DATE_FORMAT).format(time);
        // 修改字段值
        int res = userMapper.updateLoginTimeById(uid, format);
        // 生成token
        if(res > 0){token = Token.enToken(uid, time);}

        return token;
    }

    @Override
    public boolean ckToken(String userName, String token){
        // 通过用户名获取
        UserVo userByName = userMapper.findUserByName(userName);
        // 拿到加密条件
        Date userLastLogin = userByName.getUserLastLogin();
        String id = Token.deToken(token, userLastLogin.getTime());
        return id.equals(userByName.getUserId().toString());
    }
}
