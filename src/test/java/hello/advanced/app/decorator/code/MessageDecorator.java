package hello.advanced.app.decorator.code;

public class MessageDecorator implements Component {

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        System.out.println("messageDecorator 실행");
        String result = component.operation();
        String decoResult = "****" + result + "****";
        System.out.println("decorator 전 >>> " + result);
        System.out.println("decorator 후 >>> " + decoResult);
        return decoResult;
    }
}
