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

        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);

        // a 주문금액 조회
        Assertions.assertEquals(userAPrice, 10000);

        /**
         * 이런 싱글톤 이슈가 멀티쓰레드로 나타나면
         * 공유필드는 조심해야함.
         */
    }

    static class TextConfig{

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}