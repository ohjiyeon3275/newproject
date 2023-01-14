package hello.advanced.app.decorator.code;

public class TimeDecorator implements Component {

    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        System.out.println("time decorator execute >>> ");
        long startTime = System.currentTimeMillis();
        String result = component.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        System.out.println("Time decorator ended >>> " + resultTime);

        return result;
    }
}
