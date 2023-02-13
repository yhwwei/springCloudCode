package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.CommonResult;
import org.example.domain.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yhw
 * @version 1.0
 **/
@RestController
@Slf4j
public class PaymentController {

    /*
    * 在阿里巴巴规范中  get是从服务器获取数据，post是向服务器传送数据
    * */

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("向数据库插入新数据结果："+result);
        if (result>0){
            return new CommonResult(200,"success"+serverPort,result);
        }
        else{
            return new CommonResult(444,"插入失败"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据byId："+payment);
        if(payment!=null){
            return new CommonResult(200,"查询成功"+serverPort,payment);
        }
        else {
            return new CommonResult(444,"查询失败"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String testGateWay(){
        return serverPort;
    }
}
