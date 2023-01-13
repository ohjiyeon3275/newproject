package hello.advanced.app.decorator.code;

public class RealComponent implements Component {
    @Override
    public String operation() {
        System.out.println("real component executed >>> ");
        return "data";
    }
}
