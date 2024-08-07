package com.kjb.controller;

import com.kjb.apis.PayFeignApi;
import com.kjb.entities.PayDTO;
import com.kjb.retutnformat.ReturnData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @author kjb~
 * @version 1.0.0
 */

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;


    // 查询单个账单
    @GetMapping("/order/pay/get/{id}")
    public ReturnData<PayDTO> getOrder(@PathVariable("id")Integer id){
        return payFeignApi.getById(id);
    }



    // 添加账单
    @PostMapping("/order/pay/add")
    public ReturnData<String> addOrder(@RequestBody PayDTO payDTO) {
        return payFeignApi.add(payDTO);
    }


    @GetMapping("/order/pay/get/info")
    public ReturnData<String> getInfo() {
        return payFeignApi.getInfo();
    }


}
