package com.lzh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = {"com.lzh.dao"})
public class Server02_APP {

    /*@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
        // 这次我们使用了OkHttp客户端,只需要注入工厂即可
        // return new RestTemplate(new OkHttp3ClientHttpRequestFactory());
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Server02_APP.class);
    }
}
