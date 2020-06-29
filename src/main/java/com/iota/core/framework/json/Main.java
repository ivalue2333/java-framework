package com.iota.core.framework.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;



public class Main {
    //json字符串-简单对象型
    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
    //json字符串-数组类型
    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
    //复杂格式json字符串
    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    public void testJSONStrToJSONObject() {
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);

        System.out.println("studentName:  " + jsonObject.getString("studentName") + ":" + "  studentAge:  "
                + jsonObject.getInteger("studentAge"));
    }

    public void testJSONObjectToJSONStr() {
        //已知JSONObject,目标要转换为json字符串
        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
        // 第一种方式
        String jsonString = JSONObject.toJSONString(jsonObject);
        // 第二种方式
        //String jsonString = jsonObject.toJSONString();
        System.out.println(jsonString);
    }

    /**
     * json字符串-简单对象到JavaBean之间的转换
     */
    public void testJSONStrToJavaBeanObj() {

        //第一种方式
//        JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
//        String studentName = jsonObject.getString("studentName");
//        Integer studentAge = jsonObject.getInteger("studentAge");
//        Student student = new Student(studentName, studentAge);

        //第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        //Student student = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});

        //第三种方式,使用Gson的思想
        Student student = JSONObject.parseObject(JSON_OBJ_STR, Student.class);
        System.out.println(student);
        System.out.println(student.getStudentAge());
        System.out.println(student.getStudentName());
    }


    public static void main(String[] args) {
        Main main = new Main();
//        main.testJSONStrToJSONObject();

        main.testJSONStrToJavaBeanObj();
    }


}
