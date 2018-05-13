package com.example.ribboinconsumer.command;

import com.example.common.domain.User;
import com.netflix.hystrix.HystrixObservableCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class UserObservableCommand extends HystrixObservableCommand<User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserObservableCommand.class);

    private RestTemplate restTemplate;
    private Long id;

    public UserObservableCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate = restTemplate;
        this.id = id;
    }

    protected Observable<User> construct() {
        return Observable.create(new OnSubscribe<User>() {
            public void call(Subscriber<? super User> observer) {
                try {
                    if (observer.isUnsubscribed()) {
                        User user = (User) UserObservableCommand.this.restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, new Object[]{UserObservableCommand.this.id});
                        observer.onNext(user);
                        observer.onCompleted();
                    }
                } catch (Exception var3) {
                    var3.printStackTrace();
                }

            }
        });
    }
}