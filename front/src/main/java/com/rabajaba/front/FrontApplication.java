package com.rabajaba.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@Slf4j
@RestController
public class FrontApplication {
    @Value("yollo")
    private String yolloProp;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WebClient.Builder webClientBuilder;

    public static void main(String[] args) {
        SpringApplication.run(FrontApplication.class, args);
    }

    @PostConstruct
    public void initialize() {
        log.info("Hello from yollo: {}.", yolloProp);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder builder() {
        return WebClient.builder();
    }

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/")
    public String test() {
//         return webClientBuilder.build().get().uri("http://back/back").retrieve().toString();
        return "Response from back: " + restTemplate.getForObject("http://back", String.class);
    }
}