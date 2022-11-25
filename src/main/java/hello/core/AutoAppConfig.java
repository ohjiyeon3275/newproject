package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/**
 * @ComponentScan의 쓰임
 */
@ComponentScan(
        // basePackages ="hello.core.member", // 범위 지정 가능 , 지정하지 않으면 (default는)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    /**
     * 여기서 MemoryMemberRepository가 두번 생성되는데 (자동 -> @Component, 수동 -> 아래와 같은 방식)
     *
     * 테스트 돌려보면 수동 빈이 자동 빈을 오버라이딩한다.
     * but, App 을 돌렸을때는 에러가 날수있으므로
     * 프로퍼티에
     * spring.main.allow-bean-definition-overriding=true
     * 설정을 해줘야함ㄴ다.
     */

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
