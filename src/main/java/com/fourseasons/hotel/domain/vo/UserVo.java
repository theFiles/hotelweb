package com.fourseasons.hotel.domain.vo;

import com.fourseasons.hotel.domain.entity.User;
import lombok.Data;

/**
 * 用户
 * @author lidaye
 */
@Data
public class UserVo extends User {
    private String token;
}
