package hello.advanced.app.proxy.dynamicproxy.code;

public class BImpl implements BInterface {

    @Override
    public String call() {
        System.out.println("B called");
        return "b";
    }
}
