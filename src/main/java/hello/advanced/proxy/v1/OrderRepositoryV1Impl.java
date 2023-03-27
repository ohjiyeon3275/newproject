package hello.advanced.proxy.v1;

public class OrderRepositoryV1Impl implements OrderRepositoryV1 {
    @Override
    public void save(String itemId) {
        // ~~ 저장하는 복잡한 로직 ~~
        if(itemId.equals("ex")) {
            throw new IllegalStateException("예욍");
        }
        System.out.println("v1 request 실행중");
        sleep(1000);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
