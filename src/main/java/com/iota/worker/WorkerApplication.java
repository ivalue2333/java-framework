package com.iota.worker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkerApplication {
    public static void main(String[] args) {
        System.out.println("The service to start.");
        SpringApplication.run(WorkerApplication.class, args);
        System.out.println("The service has started.");
    }
}
