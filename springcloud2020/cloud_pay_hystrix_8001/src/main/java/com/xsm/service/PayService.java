package com.xsm.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@Service
public class PayService {

    public String payInfo_OK(int id){

        return "当前线程: "+Thread.currentThread().getName()+"\t id"+id+"启动成功OK";
    }

    @HystrixCommand(fallbackMethod = "payInfo_fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String pauInfo_TimeOut(int id){
        //int a = 10/0;
        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程: "+Thread.currentThread().getName()+"\t id"+id+"启动成功time_out";
    }

    public String payInfo_fallback(int id){
        return "当前线程: "+Thread.currentThread().getName()+"\t id"+id+"调用服务失败,进入服务降级";
    }

}
