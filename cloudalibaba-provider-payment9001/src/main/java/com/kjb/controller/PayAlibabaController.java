package com.kjb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */
@RestController
public class PayAlibabaController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/nacos/{id}")
    public String getPort(@PathVariable("id") Integer id) {
        return "id:" + id + "port:" + port;
    }
}
