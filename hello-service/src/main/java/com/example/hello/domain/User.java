package com.example.hello.domain;

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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
