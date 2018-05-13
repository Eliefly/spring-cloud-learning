package com.example.helloserviceapi.service;

import com.example.common.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloServiceApi
 */
@RequestMapping({"/refactor"})
public interface HelloServiceApi {

    @RequestMapping(value = {"/hello4"}, method = {RequestMethod.GET})
    String hello4(@RequestParam("name") String var1);

    @RequestMapping(value = {"/hello5"}, method = {RequestMethod.POST})
    User hello5(@RequestHeader("name") String var1, @RequestHeader("age") Integer var2);

    @RequestMapping(value = {"/hello6"}, method = {RequestMethod.POST})
    String hello6(@RequestBody User user);
}
