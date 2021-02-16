package com.renxf.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.renxf.product.mapper")
@EnableDiscoveryClient
public class ProductApplication9201 {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication9201.class,args);
    }
}
