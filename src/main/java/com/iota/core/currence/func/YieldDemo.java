package com.iota.core.currence.func;


/*
    yield 告诉当前正在执行的线程把运行机会交给线程池中拥有相同优先级的线程。
    它仅能使一个线程从运行状态转到可运行状态，而不是等待或阻塞状态。
 */
class MyThread extends Thread {
    MyThread(String s) {
        super(s);
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + ": " + i);
            if (i % 10 == 0) {
                Thread.yield();
            }
        }
    }
}

public class YieldDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        t1.start();
        t2.start();
    }
}
