package com.iota.common;

import com.iota.web.controller.HelloWorldController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
    private static final Logger logger = LogManager.getLogger(HelloWorldController.class);
    public static void Info(String msg) {
        logger.info("-------------------------------- start ");
        logger.info(msg);
        logger.info("--------------------------------  end  ");
    }
}
