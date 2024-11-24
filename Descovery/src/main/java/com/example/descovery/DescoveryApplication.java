package com.example.descovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // activate the auto-configuration of eureka server
@SpringBootApplication
public class DescoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DescoveryApplication.class, args);
    }

}
