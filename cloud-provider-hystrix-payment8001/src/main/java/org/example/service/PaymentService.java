package org.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author yhw
 * @version 1.0
 **/
@Service

//如果只是在服务方法上面写 @HystrixCommand  而不指定fallbackMethod  则使用默认指定的降级方法   默认超时时间1s就降级
//运行异常  10/0也可以触发降级
@DefaultProperties(defaultFallback = "defaultFallback")
public class PaymentService {
    public String getOk(Long id){
        return "当前线程："+Thread.currentThread().getName()+" ok";
    }
    //高并发场景下访问这个  会导致getInfo_ok也变慢  需要hystrix来控制
    //对于一个服务，如果等待时间太久，就选择降级
    //那么什么样的情况我们需要进行降级呢？
    //@HystrixCommand开启服务降级功能
    //通过commandProperties来描述
    //服务降级一般写在客户端那边
    @HystrixCommand(fallbackMethod = "fallbackMethod1",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String info_timeOut(Long id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "当前线程："+Thread.currentThread().getName()+" ok";
    }
    public String fallbackMethod1(Long id){
        return "等待服务响应时间太久，降级：id号为"+id;
    }
    public String defaultFallback(){
        return "error";
    }



    //========服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),   //开启服务熔断
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), //熔断触发的最小个数，即在一定的时间窗口内请求达到一定的次数，默认20,一个时间窗口没到10个不管失败率多少都不触发
            @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds",value = "10000"),//时间窗口大小
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//熔断多长时间后，尝试放一次请求进来，默认5秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到60%且请求次数不低于阈值，触发熔断
    })
    public String paymentCircuitBreaker(Long id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String uuid = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t"+"uuid:"+uuid;
    }
    public String paymentCircuitBreaker_fallback(Long id){
        return "id不能为负数，稍后再试";
    }
}
