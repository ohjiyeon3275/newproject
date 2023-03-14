package hello.advanced.app.proxy.dynamicproxy.handler;

import hello.advanced.app.proxy.dynamicproxy.handler.InvocationHandler;

import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {

    public Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("time proxy executed");
        long startTime = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long endTime = System.currentTimeMillis();
        System.out.println("result time : " + (endTime - startTime));
        return result;

    }
}


