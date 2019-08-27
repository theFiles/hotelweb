package com.hot.controller;

import com.hot.entity.TOrder;
import com.hot.service.TOrderService;
import com.hot.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/torders")
public class TOrderContorller {
    @Resource
    TOrderService tOrderService;

    /**
     * 通过ID查订单
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/list", params = "userId")
    public Result<List<TOrder>> list(int userId) {
        try {
            List<TOrder> list = tOrderService.list(userId);
            return Result.success(list);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return Result.error();
    }

    @RequestMapping("/update")
    public Result updateNumber(int orderId, int op) {
        int num = tOrderService.update(orderId, op);
        return Result.success(num);
    }

    //删除订单
    @RequestMapping("/delete")
    public Result deleteTOrder(int orderId) {
        int deleteTOrder = tOrderService.deleteTOrder(orderId);
        return Result.success(deleteTOrder);
    }

    //查询有无记录  有着更新  无着创建
    @RequestMapping("/add")
    public Result add(int roomId, int num, int userId) {
        int add = tOrderService.add(roomId, num, userId);
        return Result.success(add);
    }
}