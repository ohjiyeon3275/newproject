package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.Strategy;

public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("result time is " + resultTime);

    }
}
