package hello.advanced.proxy;

import hello.advanced.app.trace.logtrace.FieldLogTrace;
import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.proxy.config.ConcreteProxyConfig;
import hello.advanced.proxy.config.DynamicProxyBasicConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
// @Import(InterfaceProxyConfig.class)
// @Import(ConcreteProxyConfig.class)
@Import(DynamicProxyBasicConfig.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy")
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }

}
