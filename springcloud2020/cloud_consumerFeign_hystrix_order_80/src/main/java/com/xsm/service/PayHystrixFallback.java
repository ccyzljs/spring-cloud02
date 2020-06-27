package com.xsm.service;

import org.springframework.stereotype.Component;

/**
 * Created by xushuming
 * Created Date 2020/6/18
 */
@Component
public class PayHystrixFallback implements PayHystrixService {
    @Override
    public String getOK(int id) {
        return "getOk的服务降级"+id;
    }

    @Override
    public String getTimeOut(int id) {
        return "getTimeOut的服务降级"+id;
    }
}
