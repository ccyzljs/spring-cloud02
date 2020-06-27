package com.xsm.controller;

import com.xsm.lb.MyLB;
import com.xsm.model.CommonResult;
import com.xsm.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

//    private static final String PAYMENT_URL = "http://localhost:8001/";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE/"; //当服务使用了集群,使用服务注册到eurekaService中的服务名,而不直接使用ip


    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private MyLB myLB;

    @Resource
    private RestTemplate restTemplate;


    /**
     * 使用自己写的轮询算法请求服务
     * @return
     */
    @GetMapping("/payment/lb/get/{id}")
    public CommonResult<Payment>  mySelfGetPaymentById(@PathVariable("id") Long id){
        //获取存在的服务数量
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLB.getInstance(instances);
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(instance.getUri() + "payment/selectPaymentById/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }
        return new CommonResult<>(444,"请求错误",null);

    }

}
