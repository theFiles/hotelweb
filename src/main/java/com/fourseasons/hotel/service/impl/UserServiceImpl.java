package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.domain.vo.UserVo;
import com.fourseasons.hotel.mapper.UserMapper;
import com.fourseasons.hotel.service.TokenService;
import com.fourseasons.hotel.service.UserService;
import com.fourseasons.hotel.utils.PropertiesTool;
import com.fourseasons.hotel.utils.Result;
import com.fourseasons.hotel.utils.Token;
import com.fourseasons.hotel.utils.consts.DataBaseConst;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * 用户逻辑
 * @author lidaye
 */
@Service
public class UserServiceImpl implements UserService,TokenService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(String name, String pwd) {
        // 通过名字拿到数据
        UserVo user = userMapper.findUserByName(name,1);

        // 报错：用户不存在
        if(user == null){return Result.loss();}

        // 比较密码
        if(pwd.equals(user.getUserPassword())){
            // 生成token
            user.setToken(getToken(user.getUserId()));
            return Result.success(user);
        }
        else{
            // 报错：密码有误
            return Result.error();
        }

    }

    @Override
    public Result logout(int id) {
        // 修改最后登录时间（token失效）
        int res = resetLastTime(
                id,
                new SimpleDateFormat(DataBaseConst.DATE_FORMAT).format(
                        System.currentTimeMillis()
                )
        );
        return res > 0 ?
                Result.success(null):
                Result.error();
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
    public int resetLastTime(int uid, String format) {
        return userMapper.updateLoginTimeById(uid, format);
    }

    @Override
    public boolean ckToken(String userName, String token){
        if(userName != null && token != null) {

            // 从配置中取最大时间差
            long userMaxTime = Long.parseLong(PropertiesTool.param("token", "tk.userMaxTime"));

            // 通过用户名获取
            UserVo userByName = userMapper.findUserByName(userName, 1);
            // 拿到加密条件
            long time = userByName.getUserLastLogin().getTime();

            // 是否超过时间差
            if (System.currentTimeMillis() - time < userMaxTime) {
                String id = Token.deToken(token, time);
                return id.equals(userByName.getUserId().toString());
            }
        }
        return false;
    }
}
