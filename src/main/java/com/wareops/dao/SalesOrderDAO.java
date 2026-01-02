package com.wareops.dao;

import com.wareops.entity.SalesOrder;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class SalesOrderDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(SalesOrder o){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(o);
            t.commit();
        }
    }

    public void update(SalesOrder o){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.merge(o);
            t.commit();
        }
    }

    public void delete(int id){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            SalesOrder o=s.get(SalesOrder.class, id);
            if(o!=null) s.remove(o);
            t.commit();
        }
    }

    public SalesOrder get(int id){
        try(Session s=factory.openSession()){
            return s.get(SalesOrder.class, id);
        }
    }

    public List<SalesOrder> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from SalesOrder", SalesOrder.class).list();
        }
    }

    // RPT-01: Monthly Sales Revenue by Warehouse
    public List<Object[]> monthlyRevenue(int month, int year){
        try(Session s=factory.openSession()){
            return s.createQuery(
                "select o.warehouseId, sum(i.qty * i.sellingPrice) " +
                "from SalesOrder o, OrderItem i " +
                "where o.orderId = i.orderId " +
                " and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                " and o.status <> 'CANCELLED' " +
                "group by o.warehouseId " +
                "order by sum(i.qty * i.sellingPrice) desc"
            ).setParameter("m", month)
             .setParameter("y", year)
             .list();
        }
    }

    // RPT-02: Top Selling Products by Quantity (Month)
    public List<Object[]> topSellingByQty(int month, int year){
        try(Session s=factory.openSession()){
            return s.createQuery(
                "select i.productId, sum(i.qty) " +
                "from SalesOrder o, OrderItem i " +
                "where o.orderId = i.orderId " +
                " and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                " and o.status <> 'CANCELLED' " +
                "group by i.productId " +
                "order by sum(i.qty) desc"
            ).setParameter("m", month)
             .setParameter("y", year)
             .list();
        }
    }

    // RPT-12: Bulk Delete Old Cancelled Orders (Policy Cleanup)
    public int bulkDeleteCancelled(int month, int year){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            int rows = s.createQuery(
                "delete from SalesOrder o " +
                "where o.status = 'CANCELLED' and o.orderDate < :cutoffDate"
            ).executeUpdate();
            t.commit();
            return rows;
        }
    }
}
