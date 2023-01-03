package hello.advanced.app.v5;

import hello.advanced.app.trace.callback.TraceCallback;
import hello.advanced.app.trace.callback.TraceTemplate;
import hello.advanced.app.trace.logtrace.LogTrace;
import hello.advanced.app.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request/{itemId}")
    public String request(@PathVariable String itemId){

        return template.execute("order controller", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
