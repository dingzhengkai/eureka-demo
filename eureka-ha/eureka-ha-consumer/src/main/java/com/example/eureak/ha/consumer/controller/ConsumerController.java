package com.example.eureak.ha.consumer.controller;

import com.example.eureak.ha.consumer.service.IHelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    private final IHelloService helloService;

    private static final String applicationName = "ha-provider";

    public ConsumerController(RestTemplate restTemplate, IHelloService helloService) {
        this.restTemplate = restTemplate;
        this.helloService = helloService;
    }

    @RequestMapping(value = "/feignRequest")
    public Object feignRequest() {
        return helloService.echoHello();
    }

    @RequestMapping(value = {"/", "/hello"})
    public Object commonRequest() {
        String url = "//" + applicationName + "/hello";
        return restTemplate.getForObject(url, String.class);
    }
}
