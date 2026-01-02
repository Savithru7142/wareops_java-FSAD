package com.wareops.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="SalesOrder")
public class SalesOrder {
    @Id @Column(nullable=false)
    private int orderId;
    @Column(nullable=false)
    private int warehouseId;
    @Column(nullable=false)
    private int customerId;
    @Column(nullable=false)
    private LocalDate orderDate;
    @Column(nullable=false)
    private LocalDate promisedDate;
    @Column(nullable=false)
    private String status;

    @PrePersist @PreUpdate
    private void validate(){
        if(orderDate==null||promisedDate==null||status==null||status.trim().isEmpty())
            throw new IllegalArgumentException("Order fields required");
    }

    public int getOrderId(){return orderId;}
    public void setOrderId(int id){this.orderId=id;}
    public int getWarehouseId(){return warehouseId;}
    public void setWarehouseId(int id){this.warehouseId=id;}
    public int getCustomerId(){return customerId;}
    public void setCustomerId(int id){this.customerId=id;}
    public LocalDate getOrderDate(){return orderDate;}
    public void setOrderDate(LocalDate d){this.orderDate=d;}
    public LocalDate getPromisedDate(){return promisedDate;}
    public void setPromisedDate(LocalDate d){this.promisedDate=d;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
}
