package com.wareops.dao;

import com.wareops.entity.Product;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class ProductDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(Product p){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(p);
            t.commit();
        }
    }

    public List<Product> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from Product", Product.class).list();
        }
    }

    public void deactivate(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            Product p=s.get(Product.class, id);
            if(p!=null){ p.setStatus("INACTIVE"); s.merge(p); }
            t.commit();
        }
    }
}
