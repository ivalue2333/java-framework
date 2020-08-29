package com.iota.core.currence.demo.ipp;


// volatile并不能保证非原子性操作的多线程安全问题得到解决,volatile解决的是多线程间共享变量的可见性问题,而例如多线程的i++,++i,依然还是会存在多线程问题,它是无法解决了.
public class VolatileTest {

    private static volatile int count = 0;
    private static final int times = Integer.MAX_VALUE;

    public static void main(String[] args) {

        long curTime = System.nanoTime();

        Thread decThread = new DecThread();
        decThread.start();

        // 使用run()来运行结果为0,原因是单线程执行不会有线程安全问题
        // new DecThread().run();

        System.out.println("Start thread: " + Thread.currentThread() + " i++");

        for (int i = 0; i < times; i++) {
            count++;
        }

        System.out.println("End thread: " + Thread.currentThread() + " i--");

        // 等待decThread结束
        while (decThread.isAlive()) ;

        long duration = System.nanoTime() - curTime;
        System.out.println("Result: " + count);
        System.out.format("Duration: %.2fs\n", duration / 1.0e9);
    }

    private static class DecThread extends Thread {

        @Override
        public void run() {
            System.out.println("Start thread: " + Thread.currentThread() + " i--");
            for (int i = 0; i < times; i++) {
                count--;
            }
            System.out.println("End thread: " + Thread.currentThread() + " i--");
        }
    }
}