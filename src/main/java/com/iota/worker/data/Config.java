package com.iota.worker.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {


    @Value("${chatbot.server}")
    private String chatbotServer;

    public String getChatbotServer() {
        return chatbotServer;
    }

    public void setChatbotServer(String chatbotServer) {
        this.chatbotServer = chatbotServer;
    }
}
