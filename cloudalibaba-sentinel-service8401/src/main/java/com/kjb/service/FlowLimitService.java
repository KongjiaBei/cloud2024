package com.kjb.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author kjb~
 * @version 1.0.0
 */

@Service
public class FlowLimitService {

    @SentinelResource("common")
    public String common() {
        return "common";

    }
}
