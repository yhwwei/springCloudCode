package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.CommonResult;
import org.example.domain.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yhw
 * @version 1.0
 **/
@RestController
@Slf4j
public class OrderController {
    //之前不是用eureka写死地址
    //public static final String PAYMENT_URL = "http://localhost:8001";


    //用eureka 则我们要写在eureka注册的服务名称，通过这个服务名称到eureka自动找到我们真正想要的服务所在的ip地址
    //1.微服务间的访问可以通过http://服务名/映射链接 这种方式来访问
    //原理猜测   在yml配置中写了拿到注册表
    //会从注册表中匹配这个URL
    //zookeeper操作和eureka类似  只是注册中心变了而已
    //后面服务消费者都是通过  服务名称    去匹配的

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> creat(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
