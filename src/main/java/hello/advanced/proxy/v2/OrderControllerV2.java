package hello.advanced.proxy.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/v2/proxy")
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{itemId}")
    public String request(@PathVariable String itemId) {
        orderService.orderItem(itemId);
        return "okay";
    }

    @GetMapping("/nolog")
    public String noLog() {
        return "no log ok";
    }
}
