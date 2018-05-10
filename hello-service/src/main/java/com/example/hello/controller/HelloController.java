package com.example.hello.controller;

import com.example.hello.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * 服务提供者，服务消费者最终执行的逻辑。
 */
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = {"/hello"}, method = {RequestMethod.GET})
    public String index() throws InterruptedException {
        ServiceInstance instance = this.client.getLocalServiceInstance();
        this.logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World!";
    }

    @RequestMapping(value = {"/hello1"}, method = {RequestMethod.GET})
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = {"/hello2"}, method = {RequestMethod.GET})
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        return new User(name, age);
    }

    @RequestMapping(value = {"/hello3"}, method = {RequestMethod.POST})
    public String hello(@RequestBody User user) {
        return "Hello" + user.getName() + ", " + user.getAge();
    }
}