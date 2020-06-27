package com.xsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by xushuming
 * Created Date 2020/6/15
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Pay8004Application {

    public static void main(String[] args) {
        SpringApplication.run(Pay8004Application.class,args);
    }

}
