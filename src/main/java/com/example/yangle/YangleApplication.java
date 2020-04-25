package com.example.yangle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.yangle.mapper")
public class YangleApplication{

    public static void main(String[] args) {

        SpringApplication.run(YangleApplication.class, args);
    }

}
