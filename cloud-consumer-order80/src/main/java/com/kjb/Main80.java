package com.kjb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kjb~
 * @version 1.0.0
 */// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication
//@EnableDiscoveryCli
@EnableDiscoveryClient
public class Main80 {
    public static void main(String args[]){
        SpringApplication.run(Main80.class, args);
    }


}