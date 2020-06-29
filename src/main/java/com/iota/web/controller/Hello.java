package com.iota.web.controller;

import com.iota.web.WebApplication;
import com.iota.web.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Hello {

    private static final Logger logger = LogManager.getLogger(Hello.class);

    @RequestMapping("/hello1")
    public String hello1() {
        logger.info("--------------------------------");
        return "hello1 world";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello2 world";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    private String hello3() {
        System.out.println("data");
        return "hello3 world";
    }

    @RequestMapping(value = "/hello4")
    @ResponseBody
    private User hello4() {
        User user = new User();
        user.setNickName("percy");
        return user;
    }

    @GetMapping("/hello5")
    public User hello5() {
        User user = new User();
        user.setUserName("percy");
        return user;
    }

    @PostMapping("/hello6")
    public String hello6(@RequestParam Map<String, Object> params) {
        String tmp = "name：" + params.get("name") + "\nage：" + params.get("age");
        System.out.println(tmp);
        return tmp;
    }

    @PostMapping("/hello7")
    public String hello7(@RequestBody Map params) {
        return "name：" + params.get("name") + "\n age：" + params.get("age");
    }

    @PostMapping("/hello7_1")
    public String hello7_1(@RequestBody User user) {
        return "name：" + user.getName() + "\n age：" + user.getAge();
    }
}
