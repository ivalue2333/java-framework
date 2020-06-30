package com.iota.worker.runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(1)
@Configuration
public class ServiceDemoAuto implements CommandLineRunner {

    private static final Logger logger = LogManager.getLogger(ServiceDemoAuto.class);

    @Value("${chatbot.server}")
    String chatbotServer;

    @Override
    public void run(String... args) throws Exception {
        logger.info("123456");
        logger.info(chatbotServer);
    }
}
