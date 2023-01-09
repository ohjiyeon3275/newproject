package hello.advanced.app.proxy.code;

public class RealSubject implements Subject {
    @Override
    public String operation() {

        System.out.println("operation called ! >>> ");
        sleep(1000);
        return "operation done";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
