package hello.advanced.app.proxy.concreateproxy;

public class TimeProxy extends ConcreteLogic {

    private ConcreteLogic realLogic;

    public TimeProxy(ConcreteLogic realLogic) {
        this.realLogic = realLogic;
    }

    @Override
    public String operation() {
        System.out.println("time operator execute >>> ");

        long startTime = System.currentTimeMillis();
        String result = realLogic.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("time decorator ended >>> " + resultTime);
        return result;
    }
}
