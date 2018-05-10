package com.example.feignconsumer.client;

import com.example.feignconsumer.domain.User;
import com.example.feignconsumer.client.HelloServiceClient;
import org.springframework.stereotype.Component;

/**
 * HelloServiceFallback
 *
 * @author eliefly
 * @date 2018-03-29
 */
@Component
public class HelloServiceFallback implements HelloServiceClient {

    @Override
    public String hello() {
        return "hello error";
    }

    @Override
    public String hello(String name) {
        return "hello1 error";
    }

    @Override
    public User hello(String name, Integer age) {
        return new User("unkonw", 20);
    }

    @Override
    public String hello(User user) {
        return "hello4 error";
    }
}
