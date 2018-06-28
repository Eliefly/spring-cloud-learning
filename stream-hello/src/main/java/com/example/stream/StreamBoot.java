package com.example.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * StreamBoot
 *
 * @author huangfl
 * @since 2018/6/28
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class StreamBoot {
    public static void main(String[] args) {
        SpringApplication.run(StreamBoot.class, args);
    }
}
