package com.example.demo.config;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName:JoeListener
 * Date:     2017年11月6日 下午6:28:29
 * @author   Joe
 * @version
 * @since    JDK 1.8
 */
public class MyListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器-ServletContext 初始化");
        System.out.println(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器-ServletContext 销毁");
    }
}
