package com.wareops.dao;

import com.wareops.entity.Warehouse;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class WarehouseDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(Warehouse w){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(w);
            t.commit();
        }
    }

    public List<Warehouse> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from Warehouse", Warehouse.class).list();
        }
    }
}
