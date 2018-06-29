package com.example.stream.rabbitmq.test;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * SinkSender
 * 实现@Output注解， 创建一个输出消息通道作为消息的生产者。
 *
 * @author huangfl
 * @since 2018/6/29
 */
public interface SinkSender {

    // 通道名 “input”
    @Output(value = Sink.INPUT)
    MessageChannel output();

}
