package com.wareops.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Supplier")
public class Supplier {
    @Id @Column(nullable=false)
    private int supplierId;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String gstNumber;
    @Column(nullable=false)
    private String phone;
    @Column(nullable=false)
    private String city;
    @Column(nullable=false)
    private String status;

    @PrePersist @PreUpdate
    private void validate(){
        if(name==null||name.trim().isEmpty())
            throw new IllegalArgumentException("Supplier name required");
        if(gstNumber==null||gstNumber.trim().isEmpty())
            throw new IllegalArgumentException("GST required");
        if(phone==null||phone.trim().isEmpty())
            throw new IllegalArgumentException("Phone required");
        if(city==null||city.trim().isEmpty())
            throw new IllegalArgumentException("City required");
        if(status==null||status.trim().isEmpty())
            throw new IllegalArgumentException("Status required");
    }

    public int getSupplierId(){return supplierId;}
    public void setSupplierId(int id){this.supplierId=id;}
    public String getName(){return name;}
    public void setName(String n){this.name=n;}
    public String getGstNumber(){return gstNumber;}
    public void setGstNumber(String g){this.gstNumber=g;}
    public String getPhone(){return phone;}
    public void setPhone(String p){this.phone=p;}
    public String getCity(){return city;}
    public void setCity(String c){this.city=c;}
    public String getStatus(){return status;}
    public void setStatus(String s){this.status=s;}
}
