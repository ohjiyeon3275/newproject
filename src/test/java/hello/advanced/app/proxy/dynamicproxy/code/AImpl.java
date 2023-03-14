package hello.advanced.app.proxy.dynamicproxy.code;

public class AImpl implements AInterface{

    @Override
    public String call() {
        System.out.println("A called");
        return "a";
    }
}
