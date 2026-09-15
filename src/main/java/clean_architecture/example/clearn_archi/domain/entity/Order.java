package clean_architecture.example.clearn_archi.domain.entity;
import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private final List<OrderItem> items;
    private final BigDecimal total;

    public Order(
            Long id,
            List<OrderItem> items,
            BigDecimal total
    ) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException(
                    "Order must contain at least one item"
            );
        }

        this.id = id;
        this.items = List.copyOf(items);
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void assignId(Long id) {
        if (this.id != null) {
            throw new IllegalStateException("Order already has id");
        }

        this.id = id;
    }

}
