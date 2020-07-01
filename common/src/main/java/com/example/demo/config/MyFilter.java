package com.example.demo.config;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //站点图标/favicon.ico  filter会执行2次
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        System.out.println(request.getRequestURI());
        System.out.println("MyFilter dofilter before...");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println(request.getRequestURI());
        System.out.println("MyFilter dofilter after...");

    }

    @Override
    public void destroy() {

    }
}