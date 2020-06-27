package com.xsm.controller;

import com.xsm.model.CommonResult;
import com.xsm.model.Payment;
import com.xsm.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/selectPaymentById/{id}")
    public CommonResult<Payment> getPayById(@PathVariable("id") Long id){
        return paymentService.selectPaymentById(id);
    }

}
