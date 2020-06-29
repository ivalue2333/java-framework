package com.iota.web;

import com.iota.web.service.ServiceDemo;
import com.iota.web.service.ServiceDemoAuto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


// 使用spring initializer ，勾选 core(lombok)，web(web) 实现路由功能
@SpringBootApplication
public class WebApplication {

    private static final Logger logger = LogManager.getLogger(WebApplication.class);

    @Autowired
    ServiceDemoAuto serviceDemoAuto;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        logger.info("--------------------------------");
        WebApplication main = new WebApplication();
        main.start();
    }

    public void start() {
        ServiceDemo demo = new ServiceDemo();
        demo.Publish();

        logger.info(serviceDemoAuto);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
