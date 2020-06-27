package com.xsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@SpringBootApplication
@EnableFeignClients
public class ConsumerFeign80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign80Application.class,args);
    }

}
