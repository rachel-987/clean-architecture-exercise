package clean_architecture.example.clearn_archi.application.dto;

import java.math.BigDecimal;

public class PlaceOrderOutput {

    private final Long orderId;
    private final BigDecimal total;

    public PlaceOrderOutput(
            Long orderId,
            BigDecimal total
    ) {
        this.orderId = orderId;
        this.total = total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public BigDecimal getTotal() {
        return total;
    }
}