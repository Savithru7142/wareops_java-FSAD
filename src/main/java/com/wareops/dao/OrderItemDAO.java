package com.wareops.dao;

import com.wareops.entity.OrderItem;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class OrderItemDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(OrderItem oi){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(oi);
            t.commit();
        }
    }

    public void update(OrderItem oi){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.merge(oi);
            t.commit();
        }
    }

    public void delete(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            OrderItem oi=s.get(OrderItem.class, id);
            if(oi!=null) s.remove(oi);
            t.commit();
        }
    }

    public OrderItem get(int id){
        try(Session s=factory.openSession()){
            return s.get(OrderItem.class, id);
        }
    }

    public List<OrderItem> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from OrderItem", OrderItem.class).list();
        }
    }
}
