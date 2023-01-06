package hello.advanced.proxy;

import hello.advanced.proxy.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "hello.advanced.proxy")
public class ProxyApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }
}
