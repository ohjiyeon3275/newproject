package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.DiscountPolicy;

public class Service {
    private DiscountPolicy policy;

    public Service(DiscountPolicy policy) {
        this.policy = policy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        policy.call();

        long endTime = System.currentTimeMillis();

        System.out.println("result time = " + (startTime - endTime) );
    }
}
