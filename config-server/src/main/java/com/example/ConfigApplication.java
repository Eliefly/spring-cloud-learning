package com.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * ConfigApplication
 *
 * @author huangfl
 * @since 18/5/17
 */
@EnableConfigServer
@SpringCloudApplication
@ComponentScan(basePackages = "com.example")
public class ConfigApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigApplication.class).web(true).run(args);
    }

}
