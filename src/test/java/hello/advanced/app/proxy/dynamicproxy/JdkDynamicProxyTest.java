package hello.advanced.app.proxy.dynamicproxy;

import hello.advanced.app.proxy.dynamicproxy.code.AImpl;
import hello.advanced.app.proxy.dynamicproxy.code.AInterface;
import hello.advanced.app.proxy.dynamicproxy.code.BImpl;
import hello.advanced.app.proxy.dynamicproxy.code.BInterface;
import hello.advanced.app.proxy.dynamicproxy.handler.TimeInvocationHandler;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;


public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {

        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);

        AInterface proxy = (AInterface) Proxy.newProxyInstance(
                AInterface.class.getClassLoader(),
                new Class[]{ AInterface.class },
                handler
        );
        proxy.call();
        System.out.println("target class : " + target.getClass());
        System.out.println("proxy class : " + proxy.getClass());
    }

    @Test
    void dynamicB() {

        BInterface bInterface = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(bInterface);
        BInterface proxy = (BInterface) Proxy.newProxyInstance(
                BInterface.class.getClassLoader(),
                new Class[]{BInterface.class},
                handler
        );
        proxy.call();
        System.out.println("target class : " + bInterface.getClass());
        System.out.println("proxy class : " + proxy.getClass());
    }
}
