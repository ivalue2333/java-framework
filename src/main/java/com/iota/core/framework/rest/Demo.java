package com.iota.core.framework.rest;

import com.iota.web.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    // post form, [{name=[percy], age=[120]}]
    private static void testPost2() {
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

        String data = restTemplate.postForObject(host + "/hello5", entity, String.class);
        System.out.println(data);
    }

    public static void main(String[] args) {
//        testGet();
//        testPost();
        testPost2();
    }
}
