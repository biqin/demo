package com.example.eurekaclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("my-service")
public interface MyService {

    @RequestMapping("/eureka/client")
    String getClient();

    @RequestMapping("eureka/clients")
    List<String> getClients();

}
