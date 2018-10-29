package com.rabajaba.back;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@RestController
public class BackApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackApplication.class, args);
    }
    @Value("yollo")
    private String yolloProp;

    @PostConstruct
    public void initialize() {
        log.info("Hello from yollo: {}.", yolloProp);
    }

    @RequestMapping("/")
    public String test() {
        return LocalDateTime.now().toString();
    }
}