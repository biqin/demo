package com.testasync;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestAsync {
    @Async
    public void t1() {
        System.out.println("t1:" + Thread.currentThread().getName());
    }

    @Async
    public Future<String> t2() throws InterruptedException {
        System.out.println("t2:" + Thread.currentThread().getName());
        Thread.sleep(1000);
        return new AsyncResult<>("abc");
    }
}
