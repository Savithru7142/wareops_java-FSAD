package com.wareops.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.time.LocalDate;
import java.util.List;

public class ReturnRateDAO {
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Object[]> returnRateByProduct(int warehouseId, LocalDate from, LocalDate to){
        try(Session s=factory.openSession()){
            return s.createQuery(
                "select r.productId, sum(r.qty) from ReturnLog r " +
                "where r.warehouseId=:w and r.returnDate between :f and :t " +
                "group by r.productId order by sum(r.qty) desc"
            ).setParameter("w",warehouseId)
             .setParameter("f",from)
             .setParameter("t",to)
             .list();
        }
    }

	public int bulkCloseOld(LocalDate c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
