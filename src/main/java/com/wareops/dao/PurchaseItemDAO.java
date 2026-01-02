package com.wareops.dao;

import com.wareops.entity.PurchaseItem;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class PurchaseItemDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(PurchaseItem pi){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(pi);
            t.commit();
        }
    }

    public void update(PurchaseItem pi){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.merge(pi);
            t.commit();
        }
    }

    public void delete(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            PurchaseItem pi=s.get(PurchaseItem.class, id);
            if(pi!=null) s.remove(pi);
            t.commit();
        }
    }

    public PurchaseItem get(int id){
        try(Session s=factory.openSession()){
            return s.get(PurchaseItem.class, id);
        }
    }

    public List<PurchaseItem> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from PurchaseItem", PurchaseItem.class).list();
        }
    }
}
