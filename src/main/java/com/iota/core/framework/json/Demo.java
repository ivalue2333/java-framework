package com.iota.core.framework.json;

import com.alibaba.fastjson.JSONObject;
import com.iota.web.model.User;

public class Demo {

    public static void main(String[] args) {
        User u = new User();
        u.setId(123L);
        u.setName("percy");
        u.setNickName("abc");
        u.setSchoolLocation("swjtu");

        Object data1 = JSONObject.toJSON(u);
        System.out.println(data1);
        String data2 = data1.toString();
        System.out.println(data2);

//        JSONObject.parse(data2, )
    }
}
