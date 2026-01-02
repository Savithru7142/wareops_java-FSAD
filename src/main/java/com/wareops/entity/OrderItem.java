package com.wareops.entity;

import jakarta.persistence.*;

@Entity
@Table(name="OrderItem")
public class OrderItem {
    @Id @Column(nullable=false)
    private int orderItemId;
    @Column(nullable=false)
    private int orderId;
    @Column(nullable=false)
    private int productId;
    @Column(nullable=false)
    private int qty;
    @Column(nullable=false)
    private double sellingPrice;

    @PrePersist @PreUpdate
    private void validate(){
        if(qty<=0) throw new IllegalArgumentException("Order item qty positive");
        if(sellingPrice<0) throw new IllegalArgumentException("Selling price positive");
    }

    public int getOrderItemId(){return orderItemId;}
    public void setOrderItemId(int id){this.orderItemId=id;}
    public int getOrderId(){return orderId;}
    public void setOrderId(int id){this.orderId=id;}
    public int getProductId(){return productId;}
    public void setProductId(int id){this.productId=id;}
    public int getQty(){return qty;}
    public void setQty(int q){this.qty=q;}
    public double getSellingPrice(){return sellingPrice;}
    public void setSellingPrice(double s){this.sellingPrice=s;}
}
