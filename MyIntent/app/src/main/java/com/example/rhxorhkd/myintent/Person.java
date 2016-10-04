package com.example.rhxorhkd.myintent;

import java.io.Serializable;

/**
 * Created by rhxorhkd on 2016-10-04.
 */

public class Person implements Serializable{ //그대로 객체를 전달할 수 있어

    String name;
    int age;

    public Person(){

    }
    public Person(String name, int age){
        this.name = name;
        this.age = age;
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
}
