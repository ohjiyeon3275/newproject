package hello.advanced.app.decorator;

import hello.advanced.app.decorator.code.Component;
import hello.advanced.app.decorator.code.DecoratorPatternClient;
import hello.advanced.app.decorator.code.MessageDecorator;
import hello.advanced.app.decorator.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }
}
