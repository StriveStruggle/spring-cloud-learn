package com.example.demo;

import com.netflix.hystrix.HystrixCircuitBreaker;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @author geqiang on 2017/10/18
 */
public class TestCast {
    public static void main(String[] args) {
        CountDownLatch countDownLatch=new CountDownLatch(10);
        CyclicBarrier barrier=new CyclicBarrier(10);
        System.out.println("嘿嘿");
        TestCast testCast=new TestCast();
        testCast.add(1,2);
        testCast.ObservableToSubscribe();
//        HystrixCircuitBreaker

    }

    /**
     *
     * @param a
     * @param b
     */
    public void add(int a,int b){
        System.out.println("a+b:"+(a+b));
    }

    /**
     * 订阅-发布
     */
    public void ObservableToSubscribe(){
        //创建事件源
        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello RxJava");
                subscriber.onNext("i am helloKitty");
                subscriber.onCompleted();
            }
        });
        //创建订阅者
        Subscriber<String> subscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber:"+s);
            }
        };
        //订阅
        observable.subscribe(subscriber);
    }
}
