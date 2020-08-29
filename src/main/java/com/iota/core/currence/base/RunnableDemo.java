package com.iota.core.currence.base;

public class RunnableDemo implements Runnable{

    private String msg;

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t);
        System.out.printf("name: %s, id: %d\n", t.getName(), t.getId());
        System.out.println("data->" + this.msg);
        System.out.println();
    }

    public void publish(String msg) {
        this.msg = msg;
        Thread t = new Thread(this);
        t.start();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableDemo());
        System.out.println("thread run()");
        thread.run();
        System.out.println("thread start()");
        thread.start();

        RunnableDemo rd = new RunnableDemo();
        rd.publish("abc");
    }
}