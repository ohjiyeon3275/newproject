package hello.advanced.proxy.config;

import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.proxy.concreteproxy.OrderControllerConcreteProxy;
import hello.advanced.proxy.concreteproxy.OrderRepositoryConcreteProxy;
import hello.advanced.proxy.concreteproxy.OrderServiceConcreteProxy;
import hello.advanced.proxy.v2.OrderControllerV2;
import hello.advanced.proxy.v2.OrderRepositoryV2;
import hello.advanced.proxy.v2.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 controllerV2 = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerConcreteProxy(controllerV2, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 serviceV2 = new OrderServiceV2(orderRepositoryV2(logTrace));
        return new OrderServiceConcreteProxy(serviceV2, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepositoryV2(LogTrace logTrace) {
        OrderRepositoryV2 repositoryV2 = new OrderRepositoryV2();
        return new OrderRepositoryConcreteProxy(repositoryV2, logTrace);
    }

}
