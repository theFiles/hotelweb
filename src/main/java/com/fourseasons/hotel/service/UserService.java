package com.fourseasons.hotel.service;

import com.fourseasons.hotel.utils.Result;

/**
 * @author yuzhi
 */
public interface UserService {

    Result login(String name, String pwd);
}
