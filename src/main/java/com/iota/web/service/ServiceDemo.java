package com.iota.web.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class ServiceDemo {

    private static final Logger logger = LogManager.getLogger(ServiceDemo.class);

    @Value("${chatbot.server}")
    String chatbotServer;

    public void Publish() {
        logger.info("-------------------------");
        logger.info(chatbotServer);
    }
}
