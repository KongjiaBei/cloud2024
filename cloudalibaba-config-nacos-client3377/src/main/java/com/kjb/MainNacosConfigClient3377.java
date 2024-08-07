package com.kjb;

import com.sun.tools.javac.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author kjb~
 * @version 1.0.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MainNacosConfigClient3377 {
   public static void main(String args[]){
       SpringApplication.run(MainNacosConfigClient3377.class, args);
   }
}