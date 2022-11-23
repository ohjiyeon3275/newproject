package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 여기서 private로 막아야 new를 사용한 객체생성을 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 로직 호출");
    }
}
