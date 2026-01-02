package com.wareops.dao;

import com.wareops.entity.PurchaseReceipt;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class PurchaseReceiptDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(PurchaseReceipt pr){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(pr);
            t.commit();
        }
    }

    public void update(PurchaseReceipt pr){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.merge(pr);
            t.commit();
        }
    }

    public void delete(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            PurchaseReceipt pr=s.get(PurchaseReceipt.class, id);
            if(pr!=null) s.remove(pr);
            t.commit();
        }
    }

    public PurchaseReceipt get(int id){
        try(Session s=factory.openSession()){
            return s.get(PurchaseReceipt.class, id);
        }
    }

    public List<PurchaseReceipt> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from PurchaseReceipt", PurchaseReceipt.class).list();
        }
    }
}
