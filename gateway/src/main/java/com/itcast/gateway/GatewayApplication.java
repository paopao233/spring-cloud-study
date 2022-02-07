package com.itcast.gateway;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ClassName GatewayApplication
 * Description 网关启动类
 * Author lezi
 * Date 2022/1/24 16:22
 * Version 1.0
 **/

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
