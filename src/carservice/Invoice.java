package carservice;

import java.math.BigDecimal;
import java.util.Objects;

// Invoice: Represents an invoice for a customer with total cost and payment status
public final class Invoice extends CarService {
    private BigDecimal totalCost;
    private String paymentStatus;

    public Invoice(BigDecimal totalCost, String paymentStatus) {
        this.totalCost = totalCost;
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(totalCost, invoice.totalCost)
                && Objects.equals(paymentStatus, invoice.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCost, paymentStatus);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "totalCost=" + totalCost +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
