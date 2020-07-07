package com.iota.worker.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Demo1Service implements Runnable {

    private static final Logger logger = LogManager.getLogger(Demo1Service.class);

    private String msg;

    // 使用 http 请求的方式，聊天的消息量不大
    public void Publish(String message) {
        logger.info(message);
        this.msg = message;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(10);
                logger.info(Thread.currentThread().getName() + "->" + this.msg);
                logger.info(Thread.currentThread().getName() + "->" + this.msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
