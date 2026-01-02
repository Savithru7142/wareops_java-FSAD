package com.wareops.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Product")
public class Product {
    @Id @Column(nullable=false)
    private int productId;
    @Column(nullable=false, unique=true)
    private String sku;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String category;
    @Column(nullable=false)
    private double unitPrice;
    @Column(nullable=false)
    private int reorderLevel;
    @Column(nullable=false)
    private String status;

    @PrePersist @PreUpdate
    private void validate(){
        if(sku==null||sku.trim().isEmpty())
            throw new IllegalArgumentException("SKU required");
        if(name==null||name.trim().isEmpty())
            throw new IllegalArgumentException("Product name required");
        if(category==null||category.trim().isEmpty())
            throw new IllegalArgumentException("Category required");
        if(status==null||status.trim().isEmpty())
            throw new IllegalArgumentException("Status required");
        if(unitPrice<0)
            throw new IllegalArgumentException("Unit price positive");
        if(reorderLevel<0)
            throw new IllegalArgumentException("Reorder level positive");
    }

    public int getProductId(){return productId;}
    public void setProductId(int id){this.productId=id;}
    public String getSku(){return sku;}
    public void setSku(String s){this.sku=s;}
    public String getName(){return name;}
    public void setName(String n){this.name=n;}
    public String getCategory(){return category;}
    public void setCategory(String c){this.category=c;}
    public double getUnitPrice(){return unitPrice;}
    public void setUnitPrice(double u){this.unitPrice=u;}
    public int getReorderLevel(){return reorderLevel;}
    public void setReorderLevel(int r){this.reorderLevel=r;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
}
