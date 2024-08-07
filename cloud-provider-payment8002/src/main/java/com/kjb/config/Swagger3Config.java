package com.kjb.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kjb~
 * @version 1.0.0
 */
@Configuration
public class Swagger3Config {

    @Bean
    public GroupedOpenApi PayApi() {
        return GroupedOpenApi.builder()
                .group("文付微服务块") // 设置API组的名称
                .pathsToMatch("/pay/**") // 设置匹配路径的模式，这里匹配所有以/pay/开头的路径
                .build(); // 构建并返回GroupedOpenApi对象
    }

    @Bean
    public GroupedOpenApi otherApi() {
        return GroupedOpenApi.builder()
                .group("其它微服务模块")
                .pathsToMatch("/other/**", "/others")
                .build();
    }

//    @Bean
//    public GroupedOpenApi customerApi() {
//        return GroupedOpenApi.builder()
//                .group("客户微服务块")
//                .pathsToMatch("/customer/**", "/customers")
//                .build();
//    }

    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("cloud2024")
                        .description("通用设计REST API")
                        .version("v1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("访问更多文档")
                        .url("https://www.kjb.com"));
    }
}
