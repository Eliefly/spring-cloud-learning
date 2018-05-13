package com.example.feignconsumer.client;

import com.example.common.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 通过 @FeignClient 注解，声明调用服务为 HELLO-SERVICE，到注册中心寻找该服务进行调用。
 * 实际是调用 hello-service 模块下的逻辑。
 *
 * @author huangfl
 * @since 18/3/27
 */
@FeignClient(name = "hello-service", fallback = HelloServiceFallback.class)
public interface HelloServiceClient {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}