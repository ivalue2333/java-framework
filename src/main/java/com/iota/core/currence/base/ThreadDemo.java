package com.iota.core.currence.base;

public class ThreadDemo extends Thread {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.printf("name: %s, id: %d", t.getName(), t.getId());
        System.out.println("\n");
    }

    public void test1() {
        Thread thread = new Thread(new ThreadDemo());
        System.out.println("thread run()");
        thread.run();
        System.out.println("thread start()");
        thread.start();
    }

    public void test2() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        });
        t.start();
    }

    public void test3() {
        Thread t = new Thread(() -> {
            System.out.println("runnable");
            System.out.println("runnable");
        });
        t.start();
    }

    public static void main(String[] args) {
        ThreadDemo t = new ThreadDemo();
        t.test2();
    }
}