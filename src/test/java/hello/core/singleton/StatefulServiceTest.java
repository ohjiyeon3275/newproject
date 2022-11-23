package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TextConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);

        // a 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price " + price);

        /**
         * A의 금액이 20000이 되면 안되는뎅!
         */
        Assertions.assertEquals(statefulService1.getPrice(), 20000);
    }

    static class TextConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}