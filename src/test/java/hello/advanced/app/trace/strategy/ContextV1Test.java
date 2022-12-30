package hello.advanced.app.trace.strategy;


import hello.advanced.app.trace.strategy.code.Strategy;
import org.junit.jupiter.api.Test;

public class ContextV1Test {

    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic2() {
    }

    private void logic1() {
    }

    @Test
    void strategeV1() {
        Strategy strategyLogic1 = new StrategeLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        Strategy strategyLogic2 = new StrategeLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV2() {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                System.out.println("logic 1 execute");
            }
        };
        System.out.println("strategyLogic1" + strategyLogic1.getClass()); //ContextV1Test$1 익명클래스 생성됨
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                System.out.println("logic 2 execute");
            }
        };
        System.out.println("strategyLogic2" + strategyLogic2.getClass());
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }

    @Test
    void strategyV3() {
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                System.out.println("logic 1 execute");
            }
        });
        context1.execute();

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                System.out.println("logic 2 execute");
            }
        });
        context2.execute();
    }

    @Test
    void strategyV4() {
        ContextV1 context1 = new ContextV1(() -> System.out.println("logic 1 execute"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> System.out.println("logic 2 execute"));
        context2.execute();
    }

}
