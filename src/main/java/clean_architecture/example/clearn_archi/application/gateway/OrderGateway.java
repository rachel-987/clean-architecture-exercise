package clean_architecture.example.clearn_archi.application.gateway;

import clean_architecture.example.clearn_archi.domain.entity.Order;

public interface OrderGateway {
    Order save(Order order);
}