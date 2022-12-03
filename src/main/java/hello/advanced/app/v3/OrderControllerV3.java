package hello.advanced.app.v3;

import hello.advanced.app.trace.TraceStatus;
import hello.advanced.app.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v3/request/{itemId}")
    public String request(@PathVariable String itemId){

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()"); // 로그 시작
            orderService.orderItem(itemId);
            trace.end(status); // 로그 끝
        } catch (Exception e) {
          trace.exception(status, e); // 로그 에러시
          throw e; // exception 시에 에러 던지는 것..!
        }
        return "Ok";
    }
}
