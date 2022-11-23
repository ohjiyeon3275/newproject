package hello.core.singleton;

public class StatefulService {

    private int price; // 상태 유지하는 필드 10000 -> 20000

    public int order(String name, int price) {
        return price;
    }

}
