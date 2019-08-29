package com.vip.hotel.controller;

import com.vip.hotel.entity.TOrder;
import com.vip.hotel.service.TOrderService;
import com.vip.hotel.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/torders")
@Slf4j
public class TOrderContorller {
    @Resource
    TOrderService tOrderService;

    /**
     * 通过ID查订单
     *
     * @param userId
     * @return
     */
/*
    @GetMapping(value = "/list", params = "userId")
*/
    @RequestMapping("/list")
   /* public Result<List<TOrder>> list(int userId) {*/
    public Result getTOrderDate(int userId){
        try {
            List<TOrder> tOrder = tOrderService.getTOrder(userId);
            return Result.success(tOrder);
        } catch (Exception e) {
        /*    log.error(e.getMessage());*/
            return Result.error();
        }

    }

   /* public Result updateNumber(int orderId, int op) {
        int num = tOrderService.update(orderId, op);
        return Result.success(num);
    }
*/
    //删除订单
    @RequestMapping("/delete")
    public Result deleteTOrder(int orderId) {
        int deleteTOrder = tOrderService.deleteTorder(orderId);
        return Result.success(deleteTOrder);
    }

    //查询有无记录  有着更新  无着创建
    public Result add(int roomId, int num,int userId,int orderCode,int orderPrice,int orderId) {
        int add = tOrderService.add(roomId,userId,orderCode,orderPrice,orderId);
        return Result.success(add);
    }
}