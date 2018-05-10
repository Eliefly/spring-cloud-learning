package com.example.feignconsumer.client;

import com.example.helloserviceapi.service.HelloServiceApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * RefactorHelloService
 * 重构Feign消费者的服务，继承hello-client-api模块的HelloService接口
 * fallback 指定服务对应的降级实现类。
 *
 * @author eliefly
 * @date 2018-03-29
 */
@FeignClient(name = "hello-service", fallback = RefactorHelloServiceFallback.class)
public interface RefactorHelloServiceClient extends HelloServiceApi {

}
