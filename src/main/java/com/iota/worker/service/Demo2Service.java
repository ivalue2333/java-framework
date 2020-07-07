package com.iota.worker.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Demo2Service {

    private String data;

    /*
        o.s.b.f.s.DefaultListableBeanFactory
         Creating shared instance of singleton bean 'demo2Service'
     */
    @PostConstruct
    public void init() {
        data = "abc";
        System.out.println("PostConstruct---");
    }

    public void data() {
        System.out.println("---");
        System.out.println(data);
        System.out.println("---");
    }
}
