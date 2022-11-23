package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 퓨어 DI 컨테이너")
    void pureContainer() {
        AppConfig ac = new AppConfig();

        MemberService memberService1 = ac.memberService();

        MemberService memberService2 = ac.memberService();

        System.out.println("member1 " + memberService1);
        System.out.println("member2" + memberService2);

        Assertions.assertNotSame(memberService1, memberService2);
    }

    @Test
    @DisplayName("싱글톤 사용 객체사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singleton1" + singletonService1);
        System.out.println("singleton2" + singletonService2);

        // same -> ==
        // equal -> equals()
        Assertions.assertSame(singletonService1, singletonService2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertSame(memberService1, memberService2);
    }

    /**
     * 이 부분이 바로 bean이 싱글톤 기반이라는 사실임
     * DI컨테이너에서 만들어진 객체를 반환함
     * 싱글톤은 stateless로 설계해야함
     * 가급적 읽기만 가능하게해야함
     *
     */
}
