package com.example.zuul;

import com.example.zuul.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * ZuulApplication
 *
 * @author huangfl
 * @since 18/5/13
 */
@EnableZuulProxy
@SpringCloudApplication
@ComponentScan(basePackages = "com.example")
public class ZuulApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
    }

    /**
     * 使用定义的zuul过滤器
     *
     * @return 过滤器
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

}
