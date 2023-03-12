package hello.advanced.app.proxy.reflection;

import org.junit.jupiter.api.Test;

public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        System.out.println("start >>>>>>");
        String result1 = target.callA();
        System.out.println("result : " + result1);

        System.out.println("start >>>>>>>");
        String result2 = target.callB();
        System.out.println("result : " + result2);
    }

    static class Hello {
        public String callA() {
            System.out.println("a called");
            return "A";
        }

        public String callB() {
            System.out.println("b called");
            return "B";
        }
    }

    /**
     * spring-basic 브랜치에 있는 component-scan기능에 스프링에서 지원하는 리플렉션을 사용한 적 있다.
     * 리플렉션은 클래스나 메서드의 메타정보를 사용해서 동적으로 호출하는 메서드 변경이다.
     */
}
