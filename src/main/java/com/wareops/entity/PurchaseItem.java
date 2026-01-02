package com.wareops.entity;

import jakarta.persistence.*;

@Entity
@Table(name="PurchaseItem")
public class PurchaseItem {
    @Id @Column(nullable=false)
    private int purchaseItemId;
    @Column(nullable=false)
    private int receiptId;
    @Column(nullable=false)
    private int productId;
    @Column(nullable=false)
    private int qty;
    @Column(nullable=false)
    private double unitCost;

    @PrePersist @PreUpdate
    private void validate(){
        if(qty<=0) throw new IllegalArgumentException("Purchase qty must be positive");
        if(unitCost<0) throw new IllegalArgumentException("Cost must be positive");
    }

    public int getPurchaseItemId(){return purchaseItemId;}
    public void setPurchaseItemId(int id){this.purchaseItemId=id;}
    public int getReceiptId(){return receiptId;}
    public void setReceiptId(int id){this.receiptId=id;}
    public int getProductId(){return productId;}
    public void setProductId(int id){this.productId=id;}
    public int getQty(){return qty;}
    public void setQty(int q){this.qty=q;}
    public double getUnitCost(){return unitCost;}
    public void setUnitCost(double u){this.unitCost=u;}
}
