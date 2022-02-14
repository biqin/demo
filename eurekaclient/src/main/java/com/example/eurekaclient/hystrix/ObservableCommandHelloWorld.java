package com.example.eurekaclient.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

public class ObservableCommandHelloWorld extends HystrixObservableCommand<String> {

    private final String name;

    public ObservableCommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        System.out.println("[construct] thread: " + Thread.currentThread().getName());
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                System.out.println("[construct-call] thread: " + Thread.currentThread().getName());
                if (!observer.isUnsubscribed()) {
                    observer.onNext("Hello1" + " thread: " + Thread.currentThread().getName());
                    observer.onNext("Hello2" + " thread: " + Thread.currentThread().getName());
                    observer.onNext(name + " thread:" + Thread.currentThread().getName());
                    System.out.println("complete before-----" + "thread: " + Thread.currentThread().getName() + "\r\n");
                    observer.onCompleted();
                    System.out.println("complete after------" + "thread: " + Thread.currentThread().getName() + "\r\n"
                    );
                    observer.onCompleted(); // 不会执行到
                    observer.onNext("abc"); // 不会执行到
                }
            }
        });
    }
}