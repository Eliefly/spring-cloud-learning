package com.example.stream.rabbitmq.test;

import com.example.stream.StreamBoot;
import com.example.stream.rabbitmq.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * SendTest
 *
 * @author huangfl
 * @since 2018/6/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamBoot.class) // 指定程序入口类
@WebAppConfiguration
public class SenderTest {

    // 方式1：注入绑定接口
    private SinkSender sinkSender;

    // 方式2：直接注入消息通道对象
    private MessageChannel input;

    @Autowired
    public void setSinkSender(SinkSender sinkSender) {
        this.sinkSender = sinkSender;
    }

    @Autowired
    public void setInput(MessageChannel input) {
        this.input = input;
    }

    @Test
    public void test01() {
        sinkSender.output().send(MessageBuilder.withPayload("hello sink 1.").build());
    }

    @Test
    public void test02() {
        input.send(MessageBuilder.withPayload("hello sink 2.").build());
    }

}
