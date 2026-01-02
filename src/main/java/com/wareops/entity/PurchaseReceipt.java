package com.wareops.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="PurchaseReceipt")
public class PurchaseReceipt {
    @Id @Column(nullable=false)
    private int receiptId;
    @Column(nullable=false)
    private int warehouseId;
    @Column(nullable=false)
    private int supplierId;
    @Column(nullable=false)
    private LocalDate receiptDate;
    @Column(nullable=false, unique=true)
    private String invoiceNo;
    @Column(nullable=false)
    private double totalAmount;

    @PrePersist @PreUpdate
    private void validate(){
        if(receiptDate==null)
            throw new IllegalArgumentException("Receipt date required");
        if(invoiceNo==null||invoiceNo.trim().isEmpty())
            throw new IllegalArgumentException("Invoice required");
        if(totalAmount<0)
            throw new IllegalArgumentException("Amount positive");
    }

    public int getReceiptId(){return receiptId;}
    public void setReceiptId(int id){this.receiptId=id;}
    public int getWarehouseId(){return warehouseId;}
    public void setWarehouseId(int id){this.warehouseId=id;}
    public int getSupplierId(){return supplierId;}
    public void setSupplierId(int id){this.supplierId=id;}
    public LocalDate getReceiptDate(){return receiptDate;}
    public void setReceiptDate(LocalDate d){this.receiptDate=d;}
    public String getInvoiceNo(){return invoiceNo;}
    public void setInvoiceNo(String i){this.invoiceNo=i;}
    public double getTotalAmount(){return totalAmount;}
    public void setTotalAmount(double a){this.totalAmount=a;}
}
