package com.xsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */
@SpringBootApplication
@EnableEurekaClient
public class Pay8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Pay8001Application.class, args);
    }
}
