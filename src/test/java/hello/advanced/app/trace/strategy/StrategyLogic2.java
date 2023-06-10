package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.Strategy;

public class StrategyLogic2 implements Strategy {
    @Override
    public void call() {
        System.out.println("logic2");
    }
}
