package hello.advanced.proxy.concreteproxy;

import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.proxy.v2.OrderControllerV2;

public class OrderControllerConcreteProxy extends hello.advanced.proxy.v2.OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerConcreteProxy(hello.advanced.proxy.v2.OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }


    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("orderController request");
            String result = target.request(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
