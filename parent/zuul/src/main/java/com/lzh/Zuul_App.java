package com.lzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy // 开启Zuul的网关功能
public class Zuul_App {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_App.class, args);
    }

}
