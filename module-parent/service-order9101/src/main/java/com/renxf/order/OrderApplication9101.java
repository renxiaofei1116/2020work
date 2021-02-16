package com.renxf.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.renxf.order.mapper")
public class OrderApplication9101 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication9101.class,args);
    }
}
