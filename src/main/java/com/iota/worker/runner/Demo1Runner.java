package com.iota.worker.runner;

import com.iota.worker.service.Demo1Service;
import com.iota.worker.service.Demo2Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Random;

@Order(1)
@Configuration
public class Demo1Runner implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(Demo1Runner.class);

    @Value("${chatbot.server}")
    String chatbotServer;

    @Autowired
    Demo1Service demo1Service;

    @Autowired
    Demo2Service demo2Service;

    public static String getRandomString(int length) {
        String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(chatbotServer);

        // 多线程有问题
        demo1Service.Publish(Demo1Runner.getRandomString(3));
        demo1Service.Publish(Demo1Runner.getRandomString(3));

        demo2Service.data();

    }
}
