package com.wareops.dao;

import com.wareops.entity.StockLedger;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.time.LocalDate;
import java.util.List;

public class StockLedgerDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void save(StockLedger l){
        try(Session s=factory.openSession()){
            Transaction t=s.beginTransaction();
            s.persist(l);
            t.commit();
        }
    }

    public List<StockLedger> list(){
        try(Session s=factory.openSession()){
            return s.createQuery("from StockLedger", StockLedger.class).list();
        }
    }

    // RPT-05: Inbound vs Outbound Movement (Daily Trend)
    public List<Object[]> inboundOutboundTrend(int warehouseId, LocalDate from, LocalDate to){
        try(Session s=factory.openSession()){
            return s.createQuery(
                "select l.movementDate, " +
                " sum(case when l.movementType='IN' then l.qty else 0 end), " +
                " sum(case when l.movementType='OUT' then l.qty else 0 end) " +
                "from StockLedger l " +
                "where l.warehouseId = :warehouseId " +
                " and l.movementDate between :from and :to " +
                "group by l.movementDate " +
                "order by l.movementDate asc"
            ).setParameter("warehouseId", warehouseId)
             .setParameter("from", from)
             .setParameter("to", to)
             .list();
        }
    }
}
