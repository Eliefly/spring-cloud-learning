package com.example.stream.rabbitmq.apptest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.rxjava.RxJavaProcessor;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;

/**
 * App1
 * 监听处理“input"通道的消息，处理放回消息给“output”。
 *
 * @author huangfl
 * @since 2018/6/29
 */
@EnableBinding(value = {Processor.class})
public class App1 {

    private final static Logger LOGGER = LoggerFactory.getLogger(App1.class);

    // 监听处理“input”通道的消息
    /*@StreamListener(Processor.OUTPUT)
    // SendTo: 把处理方法返回的内容已消息的方式送到“output”通道
    @SendTo(Processor.INPUT)
    public Object receiveFromInput(Object payload) {
        LOGGER.info("Received: {}", payload);
        return "From Input Channel Return - " + payload;
    }*/

    // 响应时变成改造App1
    @Bean
    public RxJavaProcessor<String, String> processor() {
        return inputStream -> inputStream.map(data -> {
            LOGGER.info("Received: {}", data);
            return data;
        }).map(data -> String.valueOf("From Input Channel Return - " + data));
    }
}
