package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.Strategy;
import org.junit.jupiter.api.Test;

public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategeLogic1());
        context.execute(new StrategeLogic2());
    }

    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                System.out.println("business logic 1 execute");
            }
        });

        context.execute(new Strategy() {
            @Override
            public void call() {
                System.out.println("business logic 2 execute");
            }
        });
    }

    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> System.out.println("business logic 1 "));
        context.execute(() -> System.out.println("business logic 2 "));
    }
}
