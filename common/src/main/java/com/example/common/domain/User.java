package com.example.common.domain;

/**
 * User
 *
 * @author huangfl
 * @since 18/5/13
 */
public class User {

    private Long id;
    String name;
    Integer age;

    public User() {
    }

    public User(String name) {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{name='" + this.name + '\'' + ", age=" + this.age + '}';
    }
}
