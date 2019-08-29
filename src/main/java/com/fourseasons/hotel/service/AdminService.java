package com.fourseasons.hotel.service;

import com.fourseasons.hotel.utils.Result;

/**
 * @author yuzhi
 */
public interface AdminService {
    Result login(String name, String pwd);
}
