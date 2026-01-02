package com.wareops.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.wareops.entity.Supplier;

import java.util.List;

public class StockReportDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Object[]> topSellingProducts(int month, int year){
        try(Session s=factory.openSession()){
            return s.createQuery(
                "select i.productId, sum(i.qty) from SalesOrder o, OrderItem i " +
                "where o.orderId=i.orderId and o.status<>'CANCELLED' " +
                "and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                "group by i.productId order by sum(i.qty) desc"
            ).setParameter("m",month)
             .setParameter("y",year)
             .list();
        }
    }

	public void save(Supplier sp) {
		// TODO Auto-generated method stub
		
	}

	public Iterable<Object[]> list() {
		// TODO Auto-generated method stub
		return null;
	}
}
