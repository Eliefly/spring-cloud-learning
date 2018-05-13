package com.example.ribboinconsumer.command;

import com.example.common.domain.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class UserPostCommand extends HystrixCommand<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserPostCommand.class);

    private RestTemplate restTemplate;

    private User user;

    public UserPostCommand(RestTemplate restTemplate, User user) {
        super(Setter.withGroupKey(Factory.asKey("UserCommandGroupKey")));
        this.restTemplate = restTemplate;
        this.user = user;
    }

    protected User run() throws Exception {
        User user = (User) this.restTemplate.postForObject("http://USER-SERVICE/users/users", this.user, User.class, new Object[0]);
        UserGetCommand.flushCache(this.user.getId());
        return user;
    }
}
