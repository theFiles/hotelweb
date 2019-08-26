package com.fourseasons.hotel.service;

import com.fourseasons.hotel.domain.entity.User;
import com.fourseasons.hotel.utils.Result;

public interface UserService {
    Result login(String userName,String passWord);

    Result logOut();

    Result registered(User user);
}
