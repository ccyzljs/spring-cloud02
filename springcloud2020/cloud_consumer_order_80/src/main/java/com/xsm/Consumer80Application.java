package com.xsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Consumer80Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer80Application.class,args);
    }
}
