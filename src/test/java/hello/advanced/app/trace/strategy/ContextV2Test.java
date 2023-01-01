package hello.advanced.app.trace.strategy;

import org.junit.jupiter.api.Test;

public class ContextV2Test {

    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategeLogic1());
        context.execute(new StrategeLogic2());
    }
}
