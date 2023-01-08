package hello.advanced.proxy.v2;

public class OrderServiceV2Impl implements OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;

    public OrderServiceV2Impl(OrderRepositoryV2 orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderItem(String itemId) {
        orderRepository.save(itemId);
    }
}
