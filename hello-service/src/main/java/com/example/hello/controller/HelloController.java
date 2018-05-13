package com.example.hello.controller;

import com.example.common.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者，服务消费者最终执行的逻辑。
 */
@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = {"/hello"}, method = {RequestMethod.GET})
    public String index() throws InterruptedException {
        ServiceInstance instance = this.client.getLocalServiceInstance();
        LOGGER.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
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
        return "Hello " + user.getName() + ", " + user.getAge();
    }
}