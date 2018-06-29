package com.example.stream.rabbitmq.apptest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

/**
 * App2
 * 定时发送消息到“input”通道，监听处理“output”通道。
 *
 * @author huangfl
 * @since 2018/6/29
 */
@EnableBinding(value = {Processor.class})
public class App2 {

    private final static Logger LOGGER = LoggerFactory.getLogger(App2.class);

    // 监听处理“input”通道的消息
    @StreamListener(Processor.OUTPUT)
    public void receiveFromOutput(Object payload) {
        LOGGER.info("Received: {}", payload);
    }

    /**
     * InboundChannelAdapter: 对“input”通道输出绑定。
     * <p>@Poller 将放发设置为轮询执行，定义为2000毫秒。</p>
     */
    @Bean
    @InboundChannelAdapter(value = Processor.INPUT, poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource() {
        // java8 lambda
        return () -> new GenericMessage<>(new Date());
    }
}
