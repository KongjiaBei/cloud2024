package com.kjb.controller;

import com.kjb.entities.Order;
import com.kjb.retutnformat.ReturnData;
import com.kjb.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @RequestMapping("/order/create")
    public ReturnData create(Order order) {
        orderService.create(order);
        return ReturnData.success(order);
    }
}
