package com.kjb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author kjb~
 * @version 1.0.0
 */

@MapperScan("com.kjb.mapper")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class seataOrderMain2001 {

    public static void main(String args[]){
        SpringApplication.run(seataOrderMain2001.class, args);
    }
}