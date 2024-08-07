package com.kjb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */

@RestController
@RefreshScope    // nacos配置文件修改后，实时动态刷新数据
public class NacosConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/info")
    public String getInfo() {
        return info;
    }
}
