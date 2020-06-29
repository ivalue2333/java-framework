package com.iota.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


// 使用spring initializer ，勾选 core(lombok)，web(web) 实现路由功能
@SpringBootApplication
public class WebApplication {

    private static final Logger logger = LogManager.getLogger(WebApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        logger.info("--------------------------------");
    }
}
