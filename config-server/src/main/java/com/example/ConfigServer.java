package com.example;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * ConfigApplication
 *
 * @author huangfl
 * @since 18/5/17
 */
@EnableConfigServer
@SpringCloudApplication
//@ComponentScan(basePackages = "com.example")
public class ConfigServer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigServer.class).web(true).run(args);
    }

}
