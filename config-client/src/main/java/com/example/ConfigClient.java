package com.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ConfigClient
 *
 * @author huangfl
 * @since 2018/5/21
 */
@SpringCloudApplication
@ComponentScan(basePackages = "com.example")
public class ConfigClient {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigClient.class).web(true).run(args);
    }

}
