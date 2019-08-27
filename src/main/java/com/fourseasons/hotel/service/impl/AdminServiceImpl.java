package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.Admin;
import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.domain.vo.AdminVo;
import com.fourseasons.hotel.mapper.AdminMapper;
import com.fourseasons.hotel.mapper.UserMapper;
import com.fourseasons.hotel.service.AdminService;
import com.fourseasons.hotel.service.TokenService;
import com.fourseasons.hotel.utils.PropertiesTool;
import com.fourseasons.hotel.utils.Result;
import com.fourseasons.hotel.utils.Token;
import com.fourseasons.hotel.utils.consts.DataBaseConst;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 管理员逻辑
 * @author lidaye
 */
@Service
public class AdminServiceImpl implements AdminService,TokenService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Result login(String name, String pwd) {
        // 通过名字拿到数据
        AdminVo admin = adminMapper.findAdminByName(name,1);

        // 报错：用户不存在
        if(admin == null){return Result.loss();}

        // 比较密码
        if(pwd.equals(admin.getAdminPassword())){
            // 生成token
            admin.setToken(getToken(admin.getAdminId()));
            return Result.success(admin);
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
    public Result addAdmin(Admin admin) {
        int res = adminMapper.insertAdmin(admin);
        return res > 0 ?
                Result.success(null):
                Result.error();
    }

    @Override
    public Result delAdmin(int id) {
        int res = adminMapper.deleteAdmin(id);
        return res > 0 ?
                Result.success(null):
                Result.error();
    }

    @Override
    public Result getUsers(String search, int page) {
        int size = Integer.parseInt(PropertiesTool.param("db","db.findUsersSize"));
        int startNum = (page-1)*size;
        List<User> users = userMapper.findUsers(search,startNum,size);
        return users != null ?
                Result.success(users):
                Result.error();
    }

    @Override
    public Result getRooms(String search, int page) {
        return null;
    }

    @Override
    public Result getOrders(String search, int page) {
        return null;
    }


    @Override
    public int resetLastTime(int aid, String format) {
        return adminMapper.updateLoginTimeById(aid, format);
    }

    @Override
    public boolean ckToken(String name, String token) {
        // 从配置中取最大时间差
        long userMaxTime = Long.parseLong(PropertiesTool.param(token,"tk.adminMaxTime"));

        // 通过用户名获取
        AdminVo admin = adminMapper.findAdminByName(name,1);
        // 拿到加密条件
        long time = admin.getAdminLastLogin().getTime();

        // 是否超过时间差
        if(System.currentTimeMillis()-time < userMaxTime){
            String id = Token.deToken(token, time);
            return id.equals(admin.getAdminId().toString());
        }

        return false;
    }
}
