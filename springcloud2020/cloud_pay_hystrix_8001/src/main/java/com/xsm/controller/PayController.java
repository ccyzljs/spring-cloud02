package com.xsm.controller;

import com.xsm.model.CommonResult;
import com.xsm.service.PayService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@RestController
public class PayController {

    @Resource
    private PayService payService;


    @GetMapping("/pay/hystrix/ok/{id}")
    public String getOK(@PathVariable("id")int id){
        return payService.payInfo_OK(id);
    }

    @GetMapping("/pay/hystrix/timeOut/{id}")
    public String getTimeOut(@PathVariable("id")int id){
        return payService.pauInfo_TimeOut(id);
    }

}
