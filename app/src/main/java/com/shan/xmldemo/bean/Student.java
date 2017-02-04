package com.shan.xmldemo.bean;

/**
 * Created by root on 17-2-4.
 */

public class Student {
    private String name;
    private String sex;
    private String nickName;

    public Student() {
    }

    public Student(String name, String sex, String nickName) {
        this.name = name;
        this.sex = sex;
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
