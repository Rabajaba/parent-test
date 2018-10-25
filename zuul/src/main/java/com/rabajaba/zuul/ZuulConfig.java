package com.rabajaba.zuul;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import javax.annotation.PostConstruct;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class ZuulConfig {
    @Value("${server.port}")
    private Integer port;

    public static void main(String[] args) {
        SpringApplication.run(ZuulConfig.class, args);
    }

    @PostConstruct
    public void initialize() {
        log.info("Hello from zuul on port {}.", port);
    }
}
