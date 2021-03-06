package com.rabajaba.discovery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
@RestController
public class DiscoveryServer {
    @Value("${server.port}")
    private int port;

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServer.class, args);
    }

    @PostConstruct
    public void initialize() {
        log.info("Hello from Eureka Server on port {}.", port);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello!";
    }
}
