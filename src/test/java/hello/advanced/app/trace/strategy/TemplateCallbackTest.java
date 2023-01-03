package hello.advanced.app.trace.strategy;

import hello.advanced.app.trace.strategy.code.Callback;
import hello.advanced.app.trace.template.code.TimeLogTemplate;
import org.junit.jupiter.api.Test;

public class TemplateCallbackTest {

    @Test
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(new Callback() {
            @Override
            public void call() {
                System.out.println("business logic 1 ");
            }
        });

        template.execute(new Callback() {
            @Override
            public void call() {
                System.out.println("business logic 2");
            }
        });
    }

    @Test
    void callbackV2() {
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> System.out.println("business logic 1 "));
        template.execute(() -> System.out.println(""));
    }
}
