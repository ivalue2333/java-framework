package com.iota.core.currence.func;

// Thread类的方法，必须带一个时间参数。会让当前线程休眠进入阻塞状态并释放CPU（阿里面试题 Sleep释放CPU，wait 也会释放cpu，
// 因为cpu资源太宝贵了，只有在线程running的时候，才会获取cpu片段），提供其他线程运行的机会且不考虑优先级，
// 但如果有同步锁则sleep不会释放锁即其他线程无法获得同步锁  可通过调用interrupt()方法来唤醒休眠线程。
public class SleepDemo implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1第" + i + "次执行");
        }
    }

    public static void main(String[] args) {
        SleepDemo sd = new SleepDemo();
        Thread td = new Thread(sd);
        td.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程第" + i + "次执行");
        }
        System.out.println("done");
    }
}
