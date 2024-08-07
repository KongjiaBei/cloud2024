package com.kjb.apis;

import com.kjb.entities.PayDTO;
import com.kjb.retutnformat.ReturnData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author kjb~
 * @version 1.0.0
 */
//@FeignClient("cloud-payment-service")
@FeignClient("cloud-gateway")
 public interface PayFeignApi {

    @GetMapping("/pay/get/{id}")
     ReturnData<PayDTO> getById(@PathVariable("id") Integer id);


    @PostMapping("/pay/add")
     ReturnData<String> add(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/get/info")
     ReturnData<String> getInfo();

    // 测试网关
    @GetMapping("/pay/get/{id}")
    ReturnData<PayDTO> getByIdByGateway(@PathVariable("id") Integer id);

    
}
