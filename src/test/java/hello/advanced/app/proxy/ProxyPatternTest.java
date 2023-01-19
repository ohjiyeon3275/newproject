package hello.advanced.app.proxy;

import hello.advanced.app.proxy.code.CacheProxy;
import hello.advanced.app.proxy.code.ProxyPatternClient;
import hello.advanced.app.proxy.code.RealSubject;
import hello.advanced.app.proxy.code.Subject;
import hello.advanced.app.proxy.concreateproxy.ConcreteClient;
import hello.advanced.app.proxy.concreateproxy.ConcreteLogic;
import hello.advanced.app.proxy.concreateproxy.TimeProxy;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        Subject realSubject = new RealSubject();
        Subject cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
