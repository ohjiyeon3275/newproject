package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.DiscountPolicy;

public class PercentDiscount implements DiscountPolicy {
    @Override
    public void call() {
        System.out.println("percent discount");
    }
}
