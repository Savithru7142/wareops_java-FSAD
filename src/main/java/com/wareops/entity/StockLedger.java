package com.wareops.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="StockLedger")
public class StockLedger {
    @Id @Column(nullable=false)
    private int ledgerId;
    @Column(nullable=false)
    private int warehouseId;
    @Column(nullable=false)
    private int productId;
    @Column(nullable=false)
    private LocalDate movementDate;
    @Column(nullable=false)
    private String movementType;
    @Column(nullable=false)
    private String refType;
    @Column(nullable=false)
    private int refId;
    @Column(nullable=false)
    private int qty;

    @PrePersist @PreUpdate
    private void validate(){
        if(movementDate==null||movementType==null||refType==null||
           movementType.trim().isEmpty()||refType.trim().isEmpty()||qty<=0)
            throw new IllegalArgumentException("Stock ledger fields required");
    }

    public int getLedgerId(){return ledgerId;}
    public void setLedgerId(int id){this.ledgerId=id;}
    public int getWarehouseId(){return warehouseId;}
    public void setWarehouseId(int id){this.warehouseId=id;}
    public int getProductId(){return productId;}
    public void setProductId(int id){this.productId=id;}
    public LocalDate getMovementDate(){return movementDate;}
    public void setMovementDate(LocalDate d){this.movementDate=d;}
    public String getMovementType(){return movementType;}
    public void setMovementType(String m){this.movementType=m;}
    public String getRefType(){return refType;}
    public void setRefType(String r){this.refType=r;}
    public int getRefId(){return refId;}
    public void setRefId(int r){this.refId=r;}
    public int getQty(){return qty;}
    public void setQty(int q){this.qty=q;}
}
