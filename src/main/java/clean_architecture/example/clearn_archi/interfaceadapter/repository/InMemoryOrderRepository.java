package clean_architecture.example.clearn_archi.interfaceadapter.repository;

import clean_architecture.example.clearn_archi.application.gateway.OrderGateway;
import clean_architecture.example.clearn_archi.domain.entity.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryOrderRepository implements OrderGateway {

    private final Map<Long, Order> orders =
            new HashMap<>();

    private final AtomicLong sequence =
            new AtomicLong(0);

    @Override
    public Order save(Order order) {

        if (order.getId() == null) {
            order.assignId(
                    sequence.incrementAndGet()
            );
        }

        orders.put(
                order.getId(),
                order
        );

        return order;
    }
}