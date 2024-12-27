package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Invoice {
    private long id;
    private String invoiceType; // "Sales" or "Purchase"
    private LocalDate date;
    private BigDecimal totalAmount;
    private Long clientId;
    private Long supplierId;

    public Invoice(Long o, String type, LocalDate date, double totalAmount, Object clientId, Object supplierId) {}

    public Invoice(String invoiceType, Date date, double totalAmount, Long clientId, Long supplierId) {
        this.invoiceType = invoiceType;
        this.totalAmount = BigDecimal.valueOf(totalAmount);
        this.clientId = clientId;
        this.supplierId = supplierId;
    }

    public Invoice() {

    }


    public Invoice(long id, String invoiceType, double totalAmount, Long clientId, Long supplierId) {
        this.id = id;
        this.invoiceType = invoiceType;

        this.totalAmount = BigDecimal.valueOf(totalAmount);
        this.clientId = clientId;
        this.supplierId = supplierId;
    }

    public Invoice(long id, String invoiceType, LocalDate date, BigDecimal totalAmount, Long clientId, Long supplierId) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }



    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceType='" + invoiceType + '\'' +
                ", date=" + date +
                ", totalAmount=" + totalAmount +
                ", clientId=" + clientId +
                ", supplierId=" + supplierId +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }
}
