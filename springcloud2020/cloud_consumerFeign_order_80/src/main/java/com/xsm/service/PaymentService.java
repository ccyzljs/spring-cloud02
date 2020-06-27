package com.xsm.service;

import com.xsm.model.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@FeignClient("CLOUD-PAYMENT-SERVICE")
@Component
public interface PaymentService {

    @GetMapping("/payment/selectPaymentById/{id}")
    CommonResult selectPaymentById(@PathVariable("id") Long id);
}
