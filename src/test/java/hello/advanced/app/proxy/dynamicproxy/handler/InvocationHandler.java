package hello.advanced.app.proxy.dynamicproxy.handler;

import java.lang.reflect.Method;

public interface InvocationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}
