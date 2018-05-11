package com.example.feignconsumer.domain;

/**
 * User
 *
 * @author eliefly
 * @date 2018-03-29
 */
public class User {

    String name;
    Integer age;

    public User() {
    }

    public User(String name, Integer age) {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "User{name='" + this.name + '\'' + ", age=" + this.age + '}';
    }
}

