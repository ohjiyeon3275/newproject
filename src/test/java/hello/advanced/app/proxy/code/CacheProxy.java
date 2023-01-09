package hello.advanced.app.proxy.code;

public class CacheProxy implements Subject {

    private Subject target;
    private String cacheValue;

    public CacheProxy(Subject target) {
        this.target = target;
    }
    @Override
    public String operation() {

        System.out.println("proxy operation called >>>");

        if(cacheValue == null ) {
            cacheValue = target.operation();
        }
        return cacheValue;
    }
}
