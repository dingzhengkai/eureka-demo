package com.example.eureka.ha.provider.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    private final DiscoveryClient discoveryClient;

    public HelloController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(value = {"/", "/hello"})
    public String echoHello() {
        discoveryClient.getServices();
        return "Hello spring cloud!";
    }
}
