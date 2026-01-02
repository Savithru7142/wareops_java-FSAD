package com.wareops.dao;

import com.wareops.entity.Bin;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class BinDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(Bin b){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(b);
            t.commit();
        }
    }

    public void update(Bin b){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.merge(b);
            t.commit();
        }
    }

    public void delete(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            Bin b=s.get(Bin.class, id);
            if(b!=null) s.remove(b);
            t.commit();
        }
    }

    public Bin get(int id){
        try(Session s=factory.openSession()){
            return s.get(Bin.class, id);
        }
    }

    public List<Bin> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from Bin", Bin.class).list();
        }
    }
}
