package com.murray.mim.rest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * "@ComponentScan" 这个注解不加的话, 注入不了commons里的Service
 * @author Murray Law
 * @date 2021/11/2 15:42
 */
@SpringBootApplication
@ComponentScan("com.murray.mim")
@MapperScan(basePackages = {"com.murray.mim.commons.mapper"})
public class MimApplication {

    public static void main(String[] args) {
        SpringApplication.run(MimApplication.class, args);
    }

}