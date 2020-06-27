package com.xsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PayHystrixApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayHystrixApplication8001.class,args);
    }

}
