package hello.advanced.app.trace.strategy;


import hello.advanced.app.trace.strategy.code.DiscountPolicy;
import hello.advanced.app.trace.strategy.code.Strategy;
import org.junit.jupiter.api.Test;

public class DiscountV1Test {


    @Test
    void DiscountTest() {
        DiscountPolicy percentDiscount = new PercentDiscount();
        Service service = new Service(percentDiscount);
        service.execute();

        DiscountPolicy priceDiscount = new PriceDiscount();
        Service service2 = new Service(priceDiscount);
        service2.execute();
    }



}
