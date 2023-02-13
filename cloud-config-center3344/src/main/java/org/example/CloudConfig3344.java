package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yhw
 * @version 1.0
 **/
@SpringBootApplication
@EnableConfigServer
public class CloudConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig3344.class,args);
    }
}
