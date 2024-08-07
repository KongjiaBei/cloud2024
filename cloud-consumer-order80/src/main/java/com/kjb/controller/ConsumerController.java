package com.kjb.controller;

import com.kjb.entities.PayDTO;
import com.kjb.retutnformat.ReturnData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author kjb~
 * @version 1.0.0
 */

@RestController
public class ConsumerController {

    @Resource
    RestTemplate restTemplate;

//    public static final String url = "http://localhost:8001";
    public static final String url = "http://cloud-payment-service";



    // 查询单个账单
    @GetMapping("/consumer/pay/get/{id}")
    public ReturnData<String> getOrder(@PathVariable("id")Integer id){
        return restTemplate.getForObject(url +"/pay/get/" + id, ReturnData.class,id);
    }




    // 查询全部账单
    @GetMapping("/consumer/pay/getall")
    public ReturnData<String> getAllOrder(){
        return restTemplate.getForObject(url +"/pay/getall", ReturnData.class);
    }

    // 添加账单
    @PostMapping("/consumer/pay/add")
    public ReturnData<String> addOrder(@RequestBody PayDTO payDTO) {
        // 这种方式是没有返回值的，如果需要有返回值，可以使用exchange发送put,delete，解决resttemplate无返回值问题，这里就先不做了
        restTemplate.postForObject(url + "/pay/add", payDTO, ReturnData.class);
        return ReturnData.success("添加成功");
    }


    // 删除账单
    @DeleteMapping("/consumer/pay/delete/{id}")
    public ReturnData<String> deleteOrder(@PathVariable("id") Integer id) {
        restTemplate.delete(url + "/pay/delete/" + id, id);
        return ReturnData.success("删除成功");
    }


    // 修改账单
    @PutMapping("/consumer/pay/update")
    public ReturnData<String> updateOrder(@RequestBody PayDTO payDTO) {
        restTemplate.put(url + "/pay/update", payDTO);
        return ReturnData.success("修改成功");
    }


    @GetMapping("/consumer/pay/get/info")
    public ReturnData<String> getInfo() {
        return restTemplate.getForObject(url +"/pay/get/info", ReturnData.class);
    }



}
