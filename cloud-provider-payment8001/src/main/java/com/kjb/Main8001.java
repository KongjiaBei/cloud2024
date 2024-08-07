package com.kjb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author kjb~
 * @version 1.0.0
 */

@SpringBootApplication
@MapperScan("com.kjb.mapper")
@EnableDiscoveryClient
public class Main8001 {

    public static void main(String[] args) {
        SpringApplication.run(Main8001.class,args);
    }
}
