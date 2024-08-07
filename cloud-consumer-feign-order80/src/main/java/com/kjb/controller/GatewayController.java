package com.kjb.controller;

import com.kjb.apis.PayFeignApi;
import com.kjb.entities.PayDTO;
import com.kjb.retutnformat.ReturnData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */

@RestController
public class GatewayController {

    @Resource
    PayFeignApi payFeignApi;

    public static final String url = "http://cloud-payment-service";


    // 使用网关,查询单个账单
    @GetMapping("/gateway/consumer/pay/get/{id}")
    public ReturnData<PayDTO> getOrderByGateway(@PathVariable("id")Integer id){
//        return restTemplate.getForObject(url +"/pay/get/" + id, ReturnData.class,id);
        ReturnData<PayDTO> byIdByGateway = payFeignApi.getByIdByGateway(id);
        return byIdByGateway;
    }
}
