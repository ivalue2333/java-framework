package com.iota.core.data_structure;


import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("name", 1);

        int data = map.get("name");
        System.out.println(data);
    }

}


