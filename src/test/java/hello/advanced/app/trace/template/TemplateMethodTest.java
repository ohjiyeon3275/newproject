package hello.advanced.app.trace.template;


import hello.advanced.app.trace.template.code.AbstractTemplate;
import hello.advanced.app.trace.template.code.SubClassLogic1;
import hello.advanced.app.trace.template.code.SubClassLogic2;
import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        /**
         * 단순하게 1, 2 구현
         */
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        System.out.println("비즈니스 로직 1");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("result time is " + resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        System.out.println("비즈니스 로직 2");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("result time is " + resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                System.out.println("로직1 ~~");
            }
        };
        System.out.println("클래스 이름 : " + template1); // hello.advanced.app.trace.template.TemplateMethodTest$1@3d9c13b5
        template1.execute();


        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                System.out.println("로직2 ~~");
            }
        };
        System.out.println("클래스 이름 : " + template2); // hello.advanced.app.trace.template.TemplateMethodTest$2@4ae9cfc1
        template2.execute();
    }

}
