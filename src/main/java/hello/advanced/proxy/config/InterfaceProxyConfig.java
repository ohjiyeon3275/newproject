package hello.advanced.proxy.config;

import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.proxy.interfaceproxy.OrderControllerInterfaceProxy;
import hello.advanced.proxy.interfaceproxy.OrderRepositoryInterfaceProxy;
import hello.advanced.proxy.interfaceproxy.OrderServiceInterfaceProxy;
import hello.advanced.proxy.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration
public class InterfaceProxyConfig {

//    @Bean
//    public OrderControllerV1 orderController(LogTrace logTrace) {
//        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
//        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
//    }
//
//    @Bean
//    public OrderServiceV1 orderService(LogTrace logTrace) {
//        OrderServiceV1Impl serviceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
//        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
//    }
//
//    @Bean
//    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
//        OrderRepositoryV1Impl repositoryImpl = new OrderRepositoryV1Impl();
//        return new OrderRepositoryInterfaceProxy(repositoryImpl, logTrace);
//    }
}
