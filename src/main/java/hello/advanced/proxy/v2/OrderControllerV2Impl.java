package hello.advanced.proxy.v2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderControllerV2Impl implements OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2Impl(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String request(String itemId) {
        orderService.orderItem(itemId);
        return "okay";
    }

    @Override
    public String noLog() {
        return "no log ok";
    }
}
