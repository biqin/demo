package com.example.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean myfilter=new FilterRegistrationBean(new MyFilter());
        myfilter.addUrlPatterns("/*");
        myfilter.setOrder(1);
        return myfilter;
    }

    @Bean
    public FilterRegistrationBean registrationBean1(){
        FilterRegistrationBean myfilter=new FilterRegistrationBean(new MyFilter1());
        myfilter.addUrlPatterns("/*");
        myfilter.setOrder(2);
        return myfilter;
    }
}
