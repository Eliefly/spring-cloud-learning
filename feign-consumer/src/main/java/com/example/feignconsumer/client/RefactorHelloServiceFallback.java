package com.example.feignconsumer.client;

import com.example.common.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RefactorHelloServiceFallback
 * RefactorHelloService 服务对应的服务降级类，实现具体的降级处理逻辑。
 *
 * @author eliefly
 * @date 2018-03-29
 */
@Component
@RequestMapping("/fallback")
public class RefactorHelloServiceFallback implements RefactorHelloServiceClient {

    @Override
    public String hello4(String names) {
        return "hello4 error";
    }

    @Override
    public User hello5(String name, Integer age) {
        return new User("unknow", 0);
    }

    @Override
    public String hello6(User user) {
        return "hello6 error";
    }
}
