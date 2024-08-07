package com.kjb.controller;

import com.kjb.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */
@RestController
public class FlowLimitController {

    @Resource
    private FlowLimitService flowLimitService;

    @GetMapping("/testa")
    public String testa() {
        return "testa";
    }


    @GetMapping("/testb")
    public String testb() {
        return "testb";
    }


    @GetMapping("/testc")
    public String testc() {
        flowLimitService.common();
        return "testc";
    }


    @GetMapping("/testd")
    public String testd() {
        flowLimitService.common();
        return "testd";
    }

    @GetMapping("/testf")
    public String testf() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "testf";
    }
}
