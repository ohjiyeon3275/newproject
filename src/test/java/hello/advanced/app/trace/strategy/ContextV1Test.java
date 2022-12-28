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
}
