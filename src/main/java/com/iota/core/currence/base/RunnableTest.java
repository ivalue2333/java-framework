package com.iota.core.currence.base;

public class RunnableTest implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.printf("name: %s, id: %d", t.getName(), t.getId());
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableTest());
        System.out.println("thread run()");
        thread.run();
        System.out.println("thread start()");
        thread.start();
    }
}