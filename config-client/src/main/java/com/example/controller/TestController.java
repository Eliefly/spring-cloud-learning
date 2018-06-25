package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author huangfl
 * @since 2018/5/21
 */
//@RefreshScope
@RestController
public class TestController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment env;

    @RequestMapping("/value/from")
    public String from() {
        return this.from;
    }

    @RequestMapping("/env/from")
    public String from2() {
        return env.getProperty("from", "undefined");
    }

}
