package com.iota.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created By Intellij IDEA
 *
 * @Author PercyG
 * @Since 2019/3/17
 * Description:
 * Modified:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String userName;
    private String passWord;
    private String email;
    private String nickName;
    private String regTime;
    private int age;
    private String name;
    private String SchoolLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolLocation() {
        return SchoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        SchoolLocation = schoolLocation;
    }
}
