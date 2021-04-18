package com.example.eurekaclient.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import java.util.concurrent.Future;

public class HystrixTest {
    public static void main(String[] args) throws Exception {
        //testSync();
        //testAsynchronous();
        //testColdObservableCommand();
        testHotObservableCommand();
    }

    //同步单个结果
    public static void testSync() {
        HystrixCommand<String> hystrixCommand = new CommandHelloWorld("world");
        String result = hystrixCommand.execute();
        System.out.println(result);
    }

    //异步单个结果
    public static void testAsynchronous() throws Exception {
        HystrixCommand<String> hystrixCommand = new CommandHelloWorld("world");
        Future<String> future = hystrixCommand.queue();
        System.out.println("before");
        String result = future.get();
        System.out.println(result);
    }

    //返回多个结果，cold Observable，有订阅者时才会发布事件
    public static void testColdObservableCommand() throws Exception {

        HystrixObservableCommand<String> observableCommand = new ObservableCommandHelloWorld("observable world");
        Observable<String> coldValue = observableCommand.toObservable();
        System.out.println("[testObservableCommand] thread: " + Thread.currentThread().getName());
        coldValue.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complate");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println("next:" + s);
            }
        });
    }

    //返回多个结果，hot Observable，创建Observable时就执行返回结果，有订阅者会再次执行返回结果
    public static void testHotObservableCommand() throws Exception {
        HystrixObservableCommand<String> observableCommand = new ObservableCommandHelloWorld("observable world");
        Observable<String> hotValue = observableCommand.observe();
        System.out.println("[testObservableCommand] thread: " + Thread.currentThread().getName());

        Thread.sleep(3000);
        hotValue.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complate");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
            }

            @Override
            public void onNext(String s) {
                System.out.println("next:" + s);
            }
        });
    }
}
