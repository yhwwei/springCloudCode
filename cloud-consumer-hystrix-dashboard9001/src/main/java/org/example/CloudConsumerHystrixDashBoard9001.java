package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author yhw
 * @version 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class CloudConsumerHystrixDashBoard9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashBoard9001.class,args);

    }
}
