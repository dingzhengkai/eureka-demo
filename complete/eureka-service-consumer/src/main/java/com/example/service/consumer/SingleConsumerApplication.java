package com.example.service.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class SingleConsumerApplication {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(SingleConsumerApplication.class, args);
    }
}

/**
 * IHelloService
 * 配置服务提供者：single-provider 是服务提供者的 application.name
 */
@FeignClient("single-provider")
interface IHelloService {
    @RequestMapping(value = "/hello")
    String echoHello();
}

@RestController
class SingleConsumerController {
    private final RestTemplate restTemplate;
    private final IHelloService helloService;

    private static final String applicationName = "single-provider";

    public SingleConsumerController(RestTemplate restTemplate, IHelloService helloService) {
        this.restTemplate = restTemplate;
        this.helloService = helloService;
    }

    @RequestMapping(value = "/feignRequest")
    public Object feignRequest() {
        return helloService.echoHello();
    }

    @RequestMapping(value = {"/","/hello"})
    public Object commonRequest() {
        String url = "//" + applicationName + "/hello";
        return restTemplate.getForObject(url, String.class);
    }
}
