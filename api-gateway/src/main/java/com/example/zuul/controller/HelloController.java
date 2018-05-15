package com.example.zuul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author huangfl
 * @since 18/5/16
 */
@RestController
public class HelloController {

    @RequestMapping("/local/hello")
    public String hello() {
        return "Zuul Local Hello World";
    }

}
