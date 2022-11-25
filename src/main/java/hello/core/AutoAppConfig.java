package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/**
 * @ComponentScan의 쓰임
 */
@ComponentScan(
        basePackages ="hello.core.member", // 범위 지정 가능 , 지정하지 않으면 (default는)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {


}
