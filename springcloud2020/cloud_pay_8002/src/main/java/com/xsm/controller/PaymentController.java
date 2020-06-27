package com.xsm.controller;

import com.xsm.model.CommonResult;
import com.xsm.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.xsm.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String server_port;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int count = paymentService.create(payment);
        log.info("插入结果:{}",count);
        if(count>0){
            return new CommonResult(200,"插入成功,端口: "+server_port,payment);
        }else {
            return new CommonResult(444,"插入失败",null);
        }

    }

    @GetMapping("/selectPaymentById/{id}")
    public CommonResult selectPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.selectPaymentById(id);
        log.info("插入结果,查询id为:{}",id);
        if(payment!=null){
            return new CommonResult(200,"查询成功,端口: "+server_port,payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

}
