package com.example.stream.rabbitmq;

import com.example.stream.rabbitmq.test.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * EnableBinding 注解用来绑定消息通道。
 * 它通过BindingBeansRegistrar加载其他的配置Bean，通过value一次性指定
 * 多个消息通道的配置。value指定多个实现了@Input @Output 注解的接口。
 * 自定义实现@Input @Output的接口通过value指定通道的名称。
 * <p>
 * Sink 接口实现了@Input注解，默认实现了”input“输入消息通道（消息订阅）的绑定配置。
 * Source 接口实现@Output注解，默认实现了”output“输出消息通道（消息生产）的绑定配置。
 * Processor 接口则是继承结合了 Sink Source。
 *
 * @author huangfl
 * @since 2018/6/28
 */
//@EnableBinding(value = {Sink.class, SinkSender.class})
//public class SinkReceiver {
//
//    private final static Logger LOGGER = LoggerFactory.getLogger(SinkReceiver.class);
//
//    // StreamListener 注解将receiveInput方法注册为”input“通道的监听处理器。
//    @StreamListener(Sink.INPUT)
//    public void receiveInput(Object payload) {
//        LOGGER.info("Input channel receivced: {}", payload);
//    }
//}
