package com.example.eureak.ha.customer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ha-provider")
public interface IHelloService {

    @RequestMapping(value = "/hello")
    String echoHello();
}
