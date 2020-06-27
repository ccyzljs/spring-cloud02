package com.xsm.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.xsm.service.PayHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xushuming
 * Created Date 2020/6/18
 */
@RestController
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class ConsumerFeignHystrixController {

    @Resource
    private PayHystrixService payHystrixService;

    @GetMapping("/consumer/getOk/{id}")
    @HystrixCommand(fallbackMethod = "pay_circuit",commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ENABLED,value = "true"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_REQUEST_VOLUME_THRESHOLD,value = "10"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS,value = "10000"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_ERROR_THRESHOLD_PERCENTAGE,value = "60")
    })
    public String getOk(@PathVariable("id") int id){
        if(id>10){
            throw new RuntimeException("***** id不能大于10");
        }
        return payHystrixService.getOK(id);
    }

    @GetMapping("/consumer/getTimeout/{id}")
    //@HystrixCommand
    public String getTimeout(@PathVariable("id") int id){
        return payHystrixService.getTimeOut(id);
    }

/*    public String payment_Global_FallbackMethod() {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }*/
    public String pay_circuit(int id) {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o,id:"+id;
    }

}
