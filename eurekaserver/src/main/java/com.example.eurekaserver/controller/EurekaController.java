package com.example.eurekaserver.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api("测试Eureka")
@RestController
@RequestMapping("/eureka")
public class EurekaController {

    //@Autowired
    //private DiscoveryClient client;

    @ApiOperation("获取EurekaClient")
    @RequestMapping(value = "clients", method= RequestMethod.GET)
    public List<String> getEurekaClients() {
        System.out.println("++++++++++++++++++++++");
        //List<String> services = client.getServices();
        List<String> services = new ArrayList<>();
        services.add("11");
        services.add("22");
        return services;
    }


    @ApiOperation("获取EurekaClient")
    @RequestMapping(value = "client", method= RequestMethod.GET)
    public String getEurekaClient() {
        return "haha";
    }
}
