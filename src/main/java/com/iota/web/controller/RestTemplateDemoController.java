package com.iota.web.controller;

import com.iota.common.LogHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateDemoController {

    private static final Logger logger = LogManager.getLogger(RestTemplateDemoController.class);

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.port}")
    String port;

    private static final String host = "http://127.0.0.1:8089";

    @RequestMapping("/rest1")
    public String rest1() {
        String data = restTemplate.getForObject(host + "/hello1", String.class);
        LogHelper.Info("data->" + data);
        return data;
    }

    @RequestMapping("/rest2")
    public String rest2() {
        String data = restTemplate.getForObject("http://127.0.0.1:" + port + "/hello1", String.class);
        LogHelper.Info("data->" + data);
        return data;
    }
}
