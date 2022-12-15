package hello.advanced.app.trace.template.code;

public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        System.out.println("resultTime is " + resultTime);
    }

    protected abstract void call();
}
