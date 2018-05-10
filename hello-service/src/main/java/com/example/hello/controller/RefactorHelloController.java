package com.example.hello.controller;

import com.example.helloserviceapi.dto.User;
import com.example.helloserviceapi.service.HelloServiceApi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefactorHelloController
 * 重构服务提供者。实现共享的接口 HelloServiceApi。
 */
@RestController
public class RefactorHelloController implements HelloServiceApi {

    public RefactorHelloController() {
    }

    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    public String hello(@RequestBody User user) {
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}
