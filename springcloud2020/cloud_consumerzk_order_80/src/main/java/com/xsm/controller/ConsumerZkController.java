package com.xsm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Created by xushuming
 * Created Date 2020/6/15
 */
@RestController
@Slf4j
public class ConsumerZkController {

    private static final String URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getZK")
    public String getZk(){
        return restTemplate.getForObject(URL+"/getZk",String.class);
    }

}
