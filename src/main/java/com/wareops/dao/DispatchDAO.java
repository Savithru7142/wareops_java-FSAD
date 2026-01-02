package com.wareops.dao;

import com.wareops.entity.Dispatch;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.time.LocalDate;
import java.util.List;

public class DispatchDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(Dispatch d){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(d);
            t.commit();
        }
    }

    public void confirm(int id, LocalDate delivered){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            Dispatch d=s.get(Dispatch.class, id);
            if(d!=null){ d.setDeliveredDate(delivered); d.setStatus("DELIVERED"); s.merge(d); }
            t.commit();
        }
    }

	public Dispatch get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Dispatch d) {
		// TODO Auto-generated method stub
		
	}

	public List<Object[]> lateDeliveries(int wid, LocalDate f, LocalDate t) {
		// TODO Auto-generated method stub
		return null;
	}
}
