package com.wareops.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Bin")
public class Bin {
    @Id @Column(nullable=false)
    private int binId;
    @Column(nullable=false)
    private int warehouseId;
    @Column(nullable=false, unique=true)
    private String code;
    @Column(nullable=false)
    private String zone;
    @Column(nullable=false)
    private int capacity;
    @Column(nullable=false)
    private String status;

    @PrePersist @PreUpdate
    private void validate(){
        if(code==null||code.trim().isEmpty())
            throw new IllegalArgumentException("Bin code required");
        if(zone==null||zone.trim().isEmpty())
            throw new IllegalArgumentException("Zone required");
        if(status==null||status.trim().isEmpty())
            throw new IllegalArgumentException("Status required");
        if(capacity<=0)
            throw new IllegalArgumentException("Capacity must be positive");
    }

    public int getBinId(){return binId;}
    public void setBinId(int id){this.binId=id;}
    public int getWarehouseId(){return warehouseId;}
    public void setWarehouseId(int id){this.warehouseId=id;}
    public String getCode(){return code;}
    public void setCode(String c){this.code=c;}
    public String getZone(){return zone;}
    public void setZone(String z){this.zone=z;}
    public int getCapacity(){return capacity;}
    public void setCapacity(int c){this.capacity=c;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
}
