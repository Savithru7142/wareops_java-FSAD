package com.wareops.entity;
import jakarta.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
    @Id @Column(nullable=false)
    private int customerId;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String phone;
    @Column(nullable=false)
    private String city;
    @Column(nullable=false)
    private String customerType;

    @PrePersist @PreUpdate
    private void validate(){
        if(name==null||name.trim().isEmpty())
            throw new IllegalArgumentException("Customer name required");
        if(phone==null||phone.trim().isEmpty())
            throw new IllegalArgumentException("Phone required");
        if(city==null||city.trim().isEmpty())
            throw new IllegalArgumentException("City required");
        if(customerType==null||customerType.trim().isEmpty())
            throw new IllegalArgumentException("Customer type required");
    }

    public int getCustomerId(){return customerId;}
    public void setCustomerId(int id){this.customerId=id;}
    public String getName(){return name;}
    public void setName(String n){this.name=n;}
    public String getPhone(){return phone;}
    public void setPhone(String p){this.phone=p;}
    public String getCity(){return city;}
    public void setCity(String c){this.city=c;}
    public String getCustomerType(){return customerType;}
    public void setCustomerType(String t){this.customerType=t;}
}
