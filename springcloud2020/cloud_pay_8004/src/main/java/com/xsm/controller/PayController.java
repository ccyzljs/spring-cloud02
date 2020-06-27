package com.xsm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by xushuming
 * Created Date 2020/6/15
 */
@RestController
@Slf4j
public class PayController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/getZk")
    public String getZk(){
        return "zk中心,port: "+port+"\t"+ UUID.randomUUID().toString();
    }

}
