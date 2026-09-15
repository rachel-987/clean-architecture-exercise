package clean_architecture.example.clearn_archi.application.dto;

import java.math.BigDecimal;
import java.util.List;

public class PlaceOrderInput {

    private final List<Item> items;

    public PlaceOrderInput(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public static class Item {

        private final String productName;
        private final int quantity;
        private final BigDecimal unitPrice;

        public Item(
                String productName,
                int quantity,
                BigDecimal unitPrice
        ) {
            this.productName = productName;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public BigDecimal getUnitPrice() {
            return unitPrice;
        }
    }
}