package com.wareops.dao;

import com.wareops.entity.Customer;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class CustomerDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(Customer c){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(c);
            t.commit();
        }
    }

    public void update(Customer c){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.merge(c);
            t.commit();
        }
    }

    public void delete(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            Customer c=s.get(Customer.class, id);
            if(c!=null) s.remove(c);
            t.commit();
        }
    }

    public Customer get(int id){
        try(Session s=factory.openSession()){
            return s.get(Customer.class, id);
        }
    }

    public List<Customer> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from Customer", Customer.class).list();
        }
    }
}
