package com.iota.core.framework.rest;

import com.iota.web.model.User;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;

public class Demo {

    private static final String host = "http://127.0.0.1:8089";

    private static void testGet() {
        RestTemplate restTemplate = new RestTemplate();
        User notice = restTemplate.getForObject(host + "/hello5", User.class);
        System.out.println(notice);
    }

    // post form, [{name=[percy], age=[120]}]
    private static void testPost() {
        RestTemplate restTemplate = new RestTemplate();
        User u = new User();

        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("name", ("percy"));
        map.add("age", (120));

        String data = restTemplate.postForObject(host + "/hello5", map, String.class);
        System.out.println(data);
    }

    // post json
    private static void testPostJson() {
        RestTemplate restTemplate = new RestTemplate();
        User u = new User();
        u.setName("percy");
        u.setAge(120);

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        String requestJson = JSONObject.toJSON(u).toString();
        System.out.println("user->" + requestJson);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        String data = restTemplate.postForObject(host + "/hello7_1", entity, String.class);
        System.out.println(data);
    }

    // post json
    private static void testPostJsonV2() {
        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setName("percy");
        user.setAge(120);

        ResponseEntity<String> userResponseEntity = restTemplate.postForEntity(host + "/hello7_1", user, String.class);
        HttpStatus statusCode = userResponseEntity.getStatusCode();
        boolean xxSuccessful = statusCode.is2xxSuccessful();
        System.out.println(xxSuccessful);
        System.out.println(userResponseEntity.getBody());
    }

    // post json
    private static void testPostJsonGetJson() {
        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setName("percy");
        user.setAge(120);

        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity(host + "/hello7_2", user, User.class);
        HttpStatus statusCode = userResponseEntity.getStatusCode();
        boolean xxSuccessful = statusCode.is2xxSuccessful();
        System.out.println(xxSuccessful);
        System.out.println(userResponseEntity.getBody());
    }



    public static void main(String[] args) {
//        testGet();
//        testPost();
//        testPostJson();
//        testPostJsonV2();
        testPostJsonGetJson();
    }
}
