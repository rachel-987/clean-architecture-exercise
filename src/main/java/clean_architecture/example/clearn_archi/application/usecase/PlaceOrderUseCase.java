package clean_architecture.example.clearn_archi.application.usecase;

import clean_architecture.example.clearn_archi.application.dto.PlaceOrderInput;
import clean_architecture.example.clearn_archi.application.dto.PlaceOrderOutput;
import clean_architecture.example.clearn_archi.application.gateway.OrderGateway;
import clean_architecture.example.clearn_archi.domain.entity.Order;
import clean_architecture.example.clearn_archi.domain.entity.OrderItem;
import clean_architecture.example.clearn_archi.domain.service.Pricing;

import java.math.BigDecimal;
import java.util.List;

public class PlaceOrderUseCase {

    private final OrderGateway orderGateway;
    private final Pricing pricing;

    public PlaceOrderUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
        this.pricing = new Pricing();
    }

    public PlaceOrderOutput execute(PlaceOrderInput input) {

        List<OrderItem> orderItems = input.getItems()
                .stream()
                .map(item -> new OrderItem(
                        item.getProductName(),
                        item.getQuantity(),
                        item.getUnitPrice()
                ))
                .toList();

        BigDecimal total =
                pricing.calculateTotal(orderItems);

        Order order =
                new Order(
                        null,
                        orderItems,
                        total
                );

        Order savedOrder =
                orderGateway.save(order);

        return new PlaceOrderOutput(
                savedOrder.getId(),
                savedOrder.getTotal()
        );
    }
}