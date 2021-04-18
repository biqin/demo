package com.testasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class TestProvider {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SpringApplication.run(TestProvider.class, args);

        System.out.println("main:" + Thread.currentThread().getName());
        TestAsync testAsync = SpringUtil.getBean(TestAsync.class);
        testAsync.t1();
        Future tmp = testAsync.t2();
        while(!tmp.isDone()) {
            System.out.println("1");
        }

        System.out.println(tmp.get());
    }


    @Bean
    public TaskExecutor getTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }
}
