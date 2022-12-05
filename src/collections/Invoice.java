package collections;

import java.math.BigDecimal;

public class Invoice {
        String id;
        BigDecimal amount;

        public Invoice(String id, BigDecimal amount) {
                this.id = id;
                this.amount = amount;
        }

        public String getId() {
                return id;
        }

        public BigDecimal getAmount() {
                return amount;
        }

        @Override
        public String toString() {
                return "Invoice{" +
                        "id='" + id + '\'' +
                        ", amount=" + amount +
                        '}';
        }
}
