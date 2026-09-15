package clean_architecture.example.clearn_archi.domain.service;

import clean_architecture.example.clearn_archi.domain.entity.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class Pricing {
    public BigDecimal calculateTotal(List<OrderItem> items) {
        return items.stream()
                .map(OrderItem::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
