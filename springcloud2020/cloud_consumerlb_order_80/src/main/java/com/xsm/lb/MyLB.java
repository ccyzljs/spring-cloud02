package com.xsm.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@Component
public class MyLB implements LoadBalancer {

    /**
     * 请求次数
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 用于获取当前服务器的请求数
     * @return
     */
    private final int getAndIncrement() {
        int current;
        int next;
        do {
            //使current为当前的请求数
            current = this.atomicInteger.get();
            //next为本次请求后请求数+1
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
            //使用while进行atomicInteger的CAS自旋锁判断,current是否与atomicInteger的值相等,相等,就将atomicInteger的值为next,返回true,不相等就返回false,重新执行do中的代码
        } while (!atomicInteger.compareAndSet(current,next));
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        //获取请求数
        int andIncrement = this.getAndIncrement();
        //使用请求数与服务器数除余,得到到访问的服务器的下标
        int index = andIncrement% serviceInstances.size();
        //返回要请求的服务器
        return serviceInstances.get(index);
    }
}
