package com.kjb.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author kjb~
 * @version 1.0.0
 */
@RestController
public class OrderNacosController {

    @Resource
    RestTemplate restTemplate;

    @Value("${service-uri.nacos-user-service}")
    public String url;

    @GetMapping("/consumer/pay/nacos/{id}")
    public String get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(url + "/pay/nacos/" + id,String.class,id);
    }

}
