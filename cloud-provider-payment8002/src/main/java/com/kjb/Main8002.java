package com.kjb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author kjb~
 * @version 1.0.0
 */// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
@MapperScan("com.kjb.mapper")
@EnableDiscoveryClient
public class Main8002 {
    public static void main(String args[]){
        SpringApplication.run(Main8002.class, args);
    }
}