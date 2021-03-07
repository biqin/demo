package com.example.eurekaclient.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.Future;

public class HystrixTest {
    public static void main(String[] args) throws Exception {
        testObservableCommand();
    }

    public static void testSync() {
        HystrixCommand<String> hystrixCommand = new CommandHelloWorld("world");
        String result = hystrixCommand.execute();
        System.out.println(result);
    }

    public static void testAsynchronous() throws Exception {
        HystrixCommand<String> hystrixCommand = new CommandHelloWorld("world");
        Future<String> future = hystrixCommand.queue();
        System.out.println("before");
        String result = future.get();
        System.out.println(result);
    }

    public static void testObservableCommand() throws Exception {
        HystrixObservableCommand<String> observableCommand = new ObservableCommandHelloWorld("observable world");
        Observable<String> dd =  observableCommand.toObservable();
        dd.subscribe(new Observer<String>() {
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

        HystrixObservableCommand<String> observableCommand1 = new ObservableCommandHelloWorld("observable world1");
        String result = observableCommand1.observe().toBlocking().first();
        System.out.println(result);
    }
}
