package com.example.eureak.ha.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ha-provider")
public interface IHelloService {

    @RequestMapping(value = "/hello")
    String echoHello();
}
