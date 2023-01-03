package hello.advanced.app.trace.template.code;

import hello.advanced.app.trace.strategy.code.Callback;

public class TimeLogTemplate {

    public void execute(Callback callback) {
        long startTime = System.currentTimeMillis();
        callback.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        System.out.println("result time is " + resultTime);
    }
}
