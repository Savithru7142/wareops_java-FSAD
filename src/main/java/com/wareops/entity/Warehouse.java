package com.wareops.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Warehouse")
public class Warehouse {
    @Id @Column(nullable=false)
    private int warehouseId;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String city;
    @Column(nullable=false)
    private String status;

    @PrePersist @PreUpdate
    private void validate(){
        if(name==null||name.trim().isEmpty())
            throw new IllegalArgumentException("Warehouse name required");
        if(city==null||city.trim().isEmpty())
            throw new IllegalArgumentException("City required");
        if(status==null||status.trim().isEmpty())
            throw new IllegalArgumentException("Status required");
    }

    public int getWarehouseId(){return warehouseId;}
    public void setWarehouseId(int id){this.warehouseId=id;}
    public String getName(){return name;}
    public void setName(String n){this.name=n;}
    public String getCity(){return city;}
    public void setCity(String c){this.city=c;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
}
