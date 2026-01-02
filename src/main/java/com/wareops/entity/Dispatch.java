package com.wareops.entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Dispatch")
public class Dispatch {
    @Id @Column(nullable=false)
    private int dispatchId;
    @Column(nullable=false)
    private int warehouseId;
    @Column(nullable=false)
    private int orderId;
    @Column(nullable=false)
    private LocalDate dispatchDate;
    @Column(nullable=false)
    private String courier;
    @Column(nullable=false, unique=true)
    private String trackingNo;
    @Column(nullable=true)
    private LocalDate deliveredDate;
    @Column(nullable=false)
    private String status;

    @PrePersist @PreUpdate
    private void validate(){
        if(dispatchDate==null)
            throw new IllegalArgumentException("Dispatch date required");
        if(courier==null||courier.trim().isEmpty())
            throw new IllegalArgumentException("Courier required");
        if(status==null||status.trim().isEmpty())
            throw new IllegalArgumentException("Status required");
    }

    public int getDispatchId(){return dispatchId;}
    public void setDispatchId(int id){this.dispatchId=id;}
    public int getWarehouseId(){return warehouseId;}
    public void setWarehouseId(int id){this.warehouseId=id;}
    public int getOrderId(){return orderId;}
    public void setOrderId(int id){this.orderId=id;}
    public LocalDate getDispatchDate(){return dispatchDate;}
    public void setDispatchDate(LocalDate d){this.dispatchDate=d;}
    public String getCourier(){return courier;}
    public void setCourier(String c){this.courier=c;}
    public String getTrackingNo(){return trackingNo;}
    public void setTrackingNo(String t){this.trackingNo=t;}
    public LocalDate getDeliveredDate(){return deliveredDate;}
    public void setDeliveredDate(LocalDate d){this.deliveredDate=d;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
}
