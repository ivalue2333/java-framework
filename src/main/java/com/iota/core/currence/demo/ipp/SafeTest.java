package com.iota.core.currence.demo.ipp;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Java提供了java.util.concurrent.atomic 包来提供线程安全的基本类型包装类,例子如下
 *
 * 结论
 *  volatile解决了线程间共享变量的可见性问题
 *  使用volatile会增加性能开销
 *  volatile并不能解决线程同步问题
 *  解决i++或者++i这样的线程同步问题需要使用synchronized或者AtomicXX系列的包装类,同时也会增加性能开销
 *
 *  https://www.cnblogs.com/zemliu/p/3298685.html
 *
 */
public class SafeTest {

    private static AtomicInteger count = new AtomicInteger(0);
    private static final int times = Integer.MAX_VALUE;

    public static void main(String[] args) {

        long curTime = System.nanoTime();

        Thread decThread = new DecThread();
        decThread.start();

        // 使用run()来运行结果为0,原因是单线程执行不会有线程安全问题
        // new DecThread().run();

        System.out.println("Start thread: " + Thread.currentThread() + " i++");

        for (int i = 0; i < times; i++) {
            count.incrementAndGet();
        }

        // 等待decThread结束
        while (decThread.isAlive()) ;

        long duration = System.nanoTime() - curTime;
        System.out.println("Result: " + count);
        System.out.format("Duration: %.2f\n", duration / 1.0e9);
    }

    private static class DecThread extends Thread {

        @Override
        public void run() {
            System.out.println("Start thread: " + Thread.currentThread() + " i--");
            for (int i = 0; i < times; i++) {
                count.decrementAndGet();
            }
            System.out.println("End thread: " + Thread.currentThread() + " i--");
        }
    }
}