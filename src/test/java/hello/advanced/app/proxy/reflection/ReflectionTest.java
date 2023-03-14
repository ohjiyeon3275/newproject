package hello.advanced.app.proxy.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

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

    @Test
    void reflection2() throws Exception {

        Class reflection = Class.forName("hello.advanced.app.proxy.reflection.ReflectionTest$Hello");

        Hello target = new Hello();

        Method methodCallA = reflection.getMethod("callA");
        Object result1 = methodCallA.invoke(target); // target의 callA를 호출
        System.out.println("result1 : " + result1);

        Method methodCallB = reflection.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        System.out.println("result2 : " + result2);
    }

    /**
     *  1. reflection으로 class를 불러오고
     *  2. 직접 target을 불러와서
     *  3. 1의 정보의 메서드를 2의 정보의 class에 실행시킨다.
     *
     *  리플렉션해 가져온 클래스 | 직접 가져온 클래스로 나눈 이유는
     *  클래스나 메서드 정보를 동적으로 변경가능해지기 때문
     *  또한 공통로직도 만들 수 있다.
     */


    @Test
    void reflection3() throws Exception {
        Class reflection = Class.forName("hello.advanced.app.proxy.reflection.ReflectionTest$Hello");

        Hello target = new Hello();

        Method methodCallA = reflection.getMethod("callA");
        dynamicCall(methodCallA, target);

        Method methodCallB = reflection.getMethod("callB");
        dynamicCall(methodCallB, target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        System.out.println("start >>> ");
        Object result = method.invoke(target);
        System.out.println("result : " + result);
    }

    /**
     * 공톨로직을 처리할 수 있게 dynamicCall을 호출했다.
     */

    /**
     * 리플렉션을 사용할때 getMethod("오타")를 만들면 컴파일당시에는 모르지만 런타임시에 오류가 나타난다.
     * 이러한 치명적 단점때문에 꺼려지는 방법이지만 잘 사용되는 기법은 아니다.
     */


}
