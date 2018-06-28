package com.example.stream.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * SinkReceiver
 *
 * @author huangfl
 * @since 2018/6/28
 */
@EnableBinding(value = {Sink.class, Source.class})
public class SinkReceiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receiveInput(Object payload) {
        LOGGER.info("Input channel receivced: {}", payload);
    }
}
