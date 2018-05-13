package com.example.ribboinconsumer.service;

import com.example.common.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

/**
 * 注解方式实现 Hystrix 命令
 */
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    /*
    1.同步方式执行
     */
    // 注解方式指定命令名称，分组，线程池。
    @HystrixCommand(fallbackMethod = "defaultUser", commandKey = "getUserById",
            groupKey = "UserGruop", threadPoolKey = "getUserByIdThread")
    @CacheResult(cacheKeyMethod = "getUserByIdCacheKey") // 执行缓存key值的生成方法
    public User getUserById(@CacheKey Long id) {
        return (User) restTemplate.getForObject("http://USER-SERVICE/users/{1}",
                User.class, id);
    }

    // 缓存key值的生成方法
    private Long getUserByIdCacheKey(Long id) {
        return id;
    }

    /*
    缓存清理
     */
    @CacheRemove(commandKey = "getUserById")
    @HystrixCommand
    public void update(@CacheKey("id") User user) {
        this.restTemplate.postForObject("http://USER-SERVICE/users", user, User.class);
    }

    // 一次服务降级
    @HystrixCommand(fallbackMethod = "defaultUserSec")
    public User defaultUser() {
        return new User("First Fallback");
    }

    // 二次服务降级
    @HystrixCommand
    public User defaultUserSec() {
        return new User("Second Fallback");
    }

    /*
    2.异步执行方式
     */
    @HystrixCommand
    public Future<User> getUserByIdAsync(final String id) {

        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://USER-SERVICE/users/{1}",
                        User.class, id);
            }
        };
    }

    /*
    3.响应时执行
     */
    @HystrixCommand
    public Observable<User> getUserById(final String id) {
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> observer) {
                try {
                    if (!observer.isUnsubscribed()) {
                        User user = restTemplate.getForObject("http://USER-SERVICE/users/{1}",
                                User.class, id);
                        observer.onNext(user);
                        observer.onCompleted();
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });
    }
}