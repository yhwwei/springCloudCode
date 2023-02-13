package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yhw
 * @version 1.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
        /*
        *  Gateway 网关服务
        * 通过配置文件里面的predicates确定是哪个路由
        * 然后通过那个路由对应的ip：port路由请求  就是改变ip和port
        * */

        /*
        * 有了服务网关可以做的事情流程：
        * 服务提供者和服务网关都注册到服务注册中心，
        * 服务消费者从服务注册中心发现服务，
        * 先把请求发给服务网关，（这里也同样可以部署多台服务网关，负载均衡给各个服务网关）
        * 通过服务网关的匹配路由、过滤之后，服务网关也通过服务注册中心将这些请求转发给真正的提供者
        *
        * */
    }
}


