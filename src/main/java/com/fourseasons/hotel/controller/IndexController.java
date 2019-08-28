package com.fourseasons.hotel.controller;

import com.fourseasons.hotel.service.IndexService;
import com.fourseasons.hotel.utils.CateBean;
import com.fourseasons.hotel.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yuzhi
 */
@RestController
@RequestMapping("/api/v2")
public class IndexController {
    @Resource
    IndexService indexService;

    /**
     *首页显示（房间类型、酒店信息、房间预订情况）
     */

    @GetMapping("index")
    public Result getIndexData() {
        try {
            CateBean cateBean = indexService.getIndexData();
            return Result.success(cateBean);
        } catch (Exception ex) {
            return Result.error();
        }
    }
}

