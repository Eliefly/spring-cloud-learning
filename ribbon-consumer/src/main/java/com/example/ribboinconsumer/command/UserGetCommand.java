package com.example.ribboinconsumer.command;

/**
 * UserGetCommand
 *
 * @author eliefly
 * @date 2018-03-29
 */

import com.example.ribboinconsumer.domain.User;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandKey.Factory;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import org.springframework.web.client.RestTemplate;

public class UserGetCommand extends HystrixCommand<User> {
    private static final HystrixCommandKey GETTER_KEY = Factory.asKey("CommandKey");
    private RestTemplate restTemplate;
    private Long id;

    public UserGetCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(Setter.withGroupKey(com.netflix.hystrix.HystrixCommandGroupKey
                .Factory.asKey("UserCommandGroupKey"))
                .andCommandKey(GETTER_KEY)
                .andThreadPoolKey(com.netflix.hystrix.HystrixThreadPoolKey.Factory.asKey("ThreadPoolKey")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    protected User run() throws Exception {
        return (User) this.restTemplate.getForObject("http://USER-SERVICE/users/{1}",
                User.class, new Object[]{this.id});
    }

    protected User getFallback() {
        return new User();
    }

    protected String getCacheKey() {
        return String.valueOf(this.id);
    }

    public static void flushCache(Long id) {
        HystrixRequestCache.getInstance(GETTER_KEY, HystrixConcurrencyStrategyDefault.getInstance()).clear(String.valueOf(id));
    }
}