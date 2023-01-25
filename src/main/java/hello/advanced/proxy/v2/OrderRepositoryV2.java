package hello.advanced.proxy.v2;

public class OrderRepositoryV2 {

    public void save(String itemId) {
        // ~~ 저장하는 복잡한 로직 ~~
        if(itemId.equals("ex")) {
            throw new IllegalStateException("예욍");
        }
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
