package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yhw
 * @version 1.0
 **/
@SpringBootApplication
//用于发现服务注册中心的服务  以及将当前应用注册到服务注册中心  能够让注册中心能够发现，扫描到该服务。
@EnableDiscoveryClient
public class ConsulApplication8007 {
    public static void main(String[] args) {
        SpringApplication.run(ConsulApplication8007.class,args);
    }
}
