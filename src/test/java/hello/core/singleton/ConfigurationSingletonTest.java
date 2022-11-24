package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println(" 1 " + memberRepository1);
        System.out.println(" 2 " + memberRepository2);
        System.out.println(" 3 " + memberRepository);

        /**
         * 셋다 똑같다!
         */
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean " + bean.getClass());

        /**
         * bean을 등록하는 순간 바이트코드를 조작한 라이브러리로 등록
         * EnhancerBySpringCGLIB
         *
         * @Bean이 붙은 메서드마다 스프링 빈이 존재하면 존재하는 bean을 반환하고
         * 없으면 생성해서 빈으로 등록하므로 이 방식으로 싱글톤을 보장함
         */

        /**
         * AppConfig@CGLIB은 AppConfig의 자식
         */

        /**
         * @Configuration아니고 @Bean만 쓴다면?
         * CGLIB기술을 쓰지 않음
         * 싱글톤이 깨져버림 -> 순수 자바코드로 돌아감(memberRepository를 3번호출)
         */
    }
}
