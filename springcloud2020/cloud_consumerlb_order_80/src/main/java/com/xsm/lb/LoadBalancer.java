package com.xsm.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    /**
     * 通过轮询算法返回要调用的服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
