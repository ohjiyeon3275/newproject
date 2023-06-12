package hello.advanced.proxy.config;

import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.proxy.handler.LogTraceFilterHandler;
import hello.advanced.proxy.v1.*;
import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    public static final String[] PATTERNS = {"request*", "order*", "save*"};

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        OrderControllerV1 orderController = new OrderControllerV1Impl(orderService(logTrace));

        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(
                    DynamicProxyFilterConfig.class.getClassLoader(),
                    new Class[]{OrderControllerV1.class},
                    new LogTraceFilterHandler(orderController, logTrace, PATTERNS)
                );
        return proxy;
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1 orderService = new OrderServiceV1Impl(orderRepository(logTrace));

        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(DynamicProxyFilterConfig.class.getClassLoader(),
                    new Class[]{OrderServiceV1.class},
                    new LogTraceFilterHandler(orderService, logTrace, PATTERNS)
                );

        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1 orderRepository = new OrderRepositoryV1Impl();

        OrderRepositoryV1 proxy = (OrderRepositoryV1) Proxy.newProxyInstance(DynamicProxyFilterConfig.class.getClassLoader(),
                    new Class[] {OrderRepositoryV1.class},
                    new LogTraceFilterHandler(orderRepository, logTrace, PATTERNS)
                );

        return proxy;
    }

}
