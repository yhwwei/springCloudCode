package org.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yhw
 * @version 1.0
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    //开启负载均衡，请求地址时判断    eureka是轮询模式
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
