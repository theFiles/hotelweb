package com.fourseasons.hotel.service.impl;

import com.fourseasons.hotel.domain.entity.TAdmin;
import com.fourseasons.hotel.mapper.TAdminMapper;
import com.fourseasons.hotel.service.AdminService;
import com.fourseasons.hotel.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuzhi
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    TAdminMapper tAdminMapper;

    @Override
    public Result login(String name, String pwd) {
        Result result = new Result();
        TAdmin tAdmin = tAdminMapper.findTAdminByName(name,pwd);
        if (tAdmin !=null){
            if (tAdmin.getAdminPassword().equals(pwd)){
                result.setState(0);
                result.setData(tAdmin);
            }else {
                result.setState(1);
            }
        }else {
            result.setState(2);
        }
        return result;
    }
}
