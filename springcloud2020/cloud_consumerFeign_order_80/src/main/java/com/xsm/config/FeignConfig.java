package com.xsm.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xushuming
 * Created Date 2020/6/16
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level logLevel(){
        return Logger.Level.FULL;
    }
}
