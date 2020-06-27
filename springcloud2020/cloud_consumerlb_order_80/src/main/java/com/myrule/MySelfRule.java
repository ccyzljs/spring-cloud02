package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置ribbon为随机算法
 * Created by xushuming
 * Created Date 2020/6/16
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }

}
