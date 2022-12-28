package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.Strategy;

public class ContextV1 {
    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();

        System.out.println("result time = " + (startTime - endTime) );
    }
}
