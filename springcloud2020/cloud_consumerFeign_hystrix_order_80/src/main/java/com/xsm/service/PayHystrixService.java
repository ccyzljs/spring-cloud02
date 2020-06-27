package com.xsm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by xushuming
 * Created Date 2020/6/18
 */
@Component
@FeignClient(value = "CLOUD-PAY-HYSTRIX-8001",fallback = PayHystrixFallback.class)
public interface PayHystrixService {

    @GetMapping("/pay/hystrix/ok/{id}")
     String getOK(@PathVariable("id")int id);

    @GetMapping("/pay/hystrix/timeOut/{id}")
     String getTimeOut(@PathVariable("id")int id);

}
