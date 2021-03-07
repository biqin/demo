package com.example.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/testConsumer")
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("consumer")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String helloConsumer() {
        String tmp =  restTemplate.getForEntity("http://my-service/eureka/client", String.class).getBody();
        System.out.println(tmp);
        return tmp;
    }

    public String fallBack() {
        return "hehehe";
    }
}
