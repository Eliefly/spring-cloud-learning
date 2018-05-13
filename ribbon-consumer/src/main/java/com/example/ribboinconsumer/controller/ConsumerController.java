package com.example.ribboinconsumer.controller;

import com.example.ribboinconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon 方式构建的服务消费者。
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /*
    //初始的消费方式
    @RequestMapping(value = {"/ribbon-consumer"}, method = {RequestMethod.GET})
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",
                String.class).getBody();
    }
    */

    /**
     * 增加 HelloService，改变消费方式
     */
    @Autowired
    HelloService helloService;

    @RequestMapping(value = {"/ribbon-consumer"}, method = {RequestMethod.GET})
    public String helloConsumer() {
        return this.helloService.helloService();
    }
}
