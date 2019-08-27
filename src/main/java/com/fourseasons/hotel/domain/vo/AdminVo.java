package com.fourseasons.hotel.domain.vo;

import com.fourseasons.hotel.domain.entity.Admin;
import lombok.Data;

/**
 * 管理员
 * @author lidaye
 */
@Data
public class AdminVo extends Admin {
    private String token;
}
