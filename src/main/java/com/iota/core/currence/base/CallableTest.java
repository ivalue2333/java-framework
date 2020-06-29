package com.iota.core.currence.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableTest implements Callable<String> {

    public CallableTest(String string) {
    }

    public CallableTest() {
    }

    @Override
    public String call() throws InterruptedException {
        Date d = new Date();
        String str = "data->" + d.toString() + Thread.currentThread();
        Thread.sleep(3000);
        return str;
    }

    //    Callable示例
    private static void callableTest() throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Callable<String> call = new CallableTest();
            Future<String> result = exec.submit(call);
//            如果在在这里获取值，即调用get函数，那么这将阻塞线程，导致其退化为单线程
//            System.out.println("线程的返回值是" + result.get());
            list.add(result);
        }
        exec.shutdown();

//        这种获取方式才正确
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }

//        值得注意的是，Python中也是这样，在进程池中获取数据是一种危险的做法, 所以语言为我们封装了接口来临时存储和获取多线程数据
    }


    //    CompletionService示例
    private static void completionServiceTest() throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        CompletionService<String> service = new ExecutorCompletionService<String>(exec);
        for (int i = 0; i < 10; i++) {
            Callable<String> call = new CallableTest();
            service.submit(call);
        }

        Thread.sleep(1000);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> result = service.take();
            list.add(result);

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).get());
        }
        exec.shutdown();
    }

    public static void Test_call() throws ExecutionException, InterruptedException {
        CallableTest callableTest = new CallableTest();
        FutureTask<String> ft = new FutureTask<>(callableTest);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread());
        CallableTest.callableTest();
//        CallableTest.completionServiceTest();
//        CallableTest.Test_call();
    }

}
