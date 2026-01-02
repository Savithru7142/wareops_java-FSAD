package com.wareops.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ReturnLog")
public class ReturnLog {

    @Id
    @Column(nullable = false)
    private int returnId;

    @Column(nullable = false)
    private int warehouseId;

    @Column(nullable = false)
    private int orderId;

    @Column(nullable = false)
    private int productId;

    @Column(nullable = false)
    private LocalDate returnDate;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private double refundAmount;

    @Column(nullable = false)
    private String status;

    @PrePersist
    @PreUpdate
    private void validate() {
        if (returnDate == null)
            throw new IllegalArgumentException("Return date is required");

        if (reason == null || reason.trim().isEmpty())
            throw new IllegalArgumentException("Return reason is required");

        if (status == null || status.trim().isEmpty())
            throw new IllegalArgumentException("Return status is required");

        if (qty <= 0)
            throw new IllegalArgumentException("Return quantity must be positive");

        if (refundAmount < 0)
            throw new IllegalArgumentException("Refund amount must be positive");
    }

    public int getReturnId() {
        return returnId;
    }

    public void setReturnId(int returnId) {
        this.returnId = returnId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
