package com.lzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaServer
public class Eureka02_APP {
    public static void main(String[] args) {
        SpringApplication.run(Eureka02_APP.class, args);
    }
}
