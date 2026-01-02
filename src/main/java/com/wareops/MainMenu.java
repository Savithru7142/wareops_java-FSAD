package com.wareops;

import com.wareops.dao.*;
import com.wareops.entity.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WarehouseDAO warehouseDAO = new WarehouseDAO();
        ProductDAO productDAO = new ProductDAO();
        StockReportDAO supplierDAO = new StockReportDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        BinDAO binDAO = new BinDAO();
        SalesOrderDAO salesOrderDAO = new SalesOrderDAO();
        DispatchDAO dispatchDAO = new DispatchDAO();
        StockLedgerDAO stockDAO = new StockLedgerDAO();
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        ReturnRateDAO returnDAO = new ReturnRateDAO();
        PurchaseItemDAO PurchaseItemDAO = new PurchaseItemDAO();
        PurchaseReceiptDAO PurchaseReceiptDAO = new PurchaseReceiptDAO();

        
        while (true) {
            System.out.println("\nMENU");
            System.out.println("1 Register Warehouse");
            System.out.println("2 Register Product");
            System.out.println("3 Register Supplier");
            System.out.println("4 Register Customer");
            System.out.println("5 Create Bin");
            System.out.println("6 Create Sales Order");
            System.out.println("7 Add Order Item");
            System.out.println("8 Dispatch Shipment");
            System.out.println("9 Confirm Delivery");
            System.out.println("10 Stock IN/OUT Report");
            System.out.println("11 Monthly Revenue Report");
            System.out.println("12 Late Deliveries Report");
            System.out.println("13 Bulk Close Old Returns");
            System.out.println("14 List Warehouses");
            System.out.println("15 List Products");
            System.out.println("16 List Bins");
            System.out.println("17 List Customers");
            System.out.println("18 List Suppliers");
            System.out.println("19 List Stock Ledger");
            System.out.println("20 Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Warehouse ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("City: ");
                String c = sc.nextLine();
                System.out.print("Status: ");
                String s = sc.nextLine();
                Warehouse w = new Warehouse();
                w.setWarehouseId(id);
                w.setName(n);
                w.setCity(c);
                w.setStatus(s);
                warehouseDAO.save(w);
                System.out.println("Saved");
            }

            else if (ch == 2) {
                System.out.print("Product ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("SKU: ");
                String sku = sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Category: ");
                String cat = sc.nextLine();
                System.out.print("Unit Price: ");
                double up = sc.nextDouble();
                System.out.print("Reorder Level: ");
                int rl = sc.nextInt(); sc.nextLine();
                System.out.print("Status: ");
                String st = sc.nextLine();
                Product p = new Product();
                p.setProductId(id);
                p.setSku(sku);
                p.setName(n);
                p.setCategory(cat);
                p.setUnitPrice(up);
                p.setReorderLevel(rl);
                p.setStatus(st);
                productDAO.save(p);
                System.out.println("Saved");
            }

            else if (ch == 3) {
                System.out.print("Supplier ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("GST Number: ");
                String gst = sc.nextLine();
                System.out.print("Phone: ");
                String ph = sc.nextLine();
                System.out.print("City: ");
                String c = sc.nextLine();
                System.out.print("Status: ");
                String s = sc.nextLine();
                Supplier sp = new Supplier();
                sp.setSupplierId(id);
                sp.setName(n);
                sp.setGstNumber(gst);
                sp.setPhone(ph);
                sp.setCity(c);
                sp.setStatus(s);
                supplierDAO.save(sp);
                System.out.println("Saved");
            }

            else if (ch == 4) {
                System.out.print("Customer ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Name: ");
                String n = sc.nextLine();
                System.out.print("Phone: ");
                String ph = sc.nextLine();
                System.out.print("City: ");
                String c = sc.nextLine();
                System.out.print("Type: ");
                String t = sc.nextLine();
                Customer cu = new Customer();
                cu.setCustomerId(id);
                cu.setName(n);
                cu.setPhone(ph);
                cu.setCity(c);
                cu.setCustomerType(t);
                customerDAO.save(cu);
                System.out.println("Saved");
            }

            else if (ch == 5) {
                System.out.print("Bin ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Warehouse ID: ");
                int wid = sc.nextInt(); sc.nextLine();
                System.out.print("Code: ");
                String cd = sc.nextLine();
                System.out.print("Zone: ");
                String zn = sc.nextLine();
                System.out.print("Capacity: ");
                int cap = sc.nextInt(); sc.nextLine();
                System.out.print("Status: ");
                String s = sc.nextLine();
                Bin b = new Bin();
                b.setBinId(id);
                b.setWarehouseId(wid);
                b.setCode(cd);
                b.setZone(zn);
                b.setCapacity(cap);
                b.setStatus(s);
                binDAO.save(b);
                System.out.println("Saved");
            }

            else if (ch == 6) {
                System.out.print("Order ID: ");
                int id = sc.nextInt();
                System.out.print("Warehouse ID: ");
                int wid = sc.nextInt();
                System.out.print("Customer ID: ");
                int cid = sc.nextInt();
                sc.nextLine();
                System.out.print("Order Date (YYYY-MM-DD): ");
                LocalDate od = LocalDate.parse(sc.nextLine());
                System.out.print("Promised Date (YYYY-MM-DD): ");
                LocalDate pd = LocalDate.parse(sc.nextLine());
                System.out.print("Status: ");
                String st = sc.nextLine();
                Warehouse cu = null;
				cu.setStatus(st);
                SalesOrder o = new SalesOrder();
                o.setOrderId(id);
                o.setWarehouseId(wid);
                o.setCustomerId(cid);
                o.setOrderDate(od);
                o.setPromisedDate(pd);
                o.setStatus(st);
                salesOrderDAO.save(o);
                System.out.println("Saved");
            }

            else if (ch == 7) {
                System.out.print("OrderItem ID: ");
                int id = sc.nextInt();
                System.out.print("Order ID: ");
                int oid = sc.nextInt();
                System.out.print("Product ID: ");
                int pid = sc.nextInt();
                System.out.print("Qty: ");
                int q = sc.nextInt();
                System.out.print("Selling Price: ");
                double sp = sc.nextDouble();
                sc.nextLine();
                OrderItem oi = new OrderItem();
                oi.setOrderItemId(id);
                oi.setOrderId(oid);
                oi.setProductId(pid);
                oi.setQty(q);
                oi.setSellingPrice(sp);
                orderItemDAO.save(oi);
                System.out.println("Saved");
            }

            else if (ch == 8) {
                System.out.print("Dispatch ID: ");
                int id = sc.nextInt();
                System.out.print("Warehouse ID: ");
                int wid = sc.nextInt();
                System.out.print("Order ID: ");
                int oid = sc.nextInt();
                sc.nextLine();
                System.out.print("Dispatch Date (YYYY-MM-DD): ");
                LocalDate dd = LocalDate.parse(sc.nextLine());
                System.out.print("Courier: ");
                String c = sc.nextLine();
                System.out.print("Tracking No: ");
                String tno = sc.nextLine();
                System.out.print("Status: ");
                String st = sc.nextLine();
                Dispatch d = new Dispatch();
                d.setDispatchId(id);
                d.setWarehouseId(wid);
                d.setOrderId(oid);
                d.setDispatchDate(dd);
                d.setCourier(c);
                d.setTrackingNo(tno);
                d.setStatus(st);
                dispatchDAO.save(d);
                System.out.println("Saved");
            }

            else if (ch == 9) {
                System.out.print("Dispatch ID: ");
                int id = sc.nextInt(); sc.nextLine();
                System.out.print("Delivery Date (YYYY-MM-DD): ");
                LocalDate del = LocalDate.parse(sc.nextLine());
                Dispatch d = dispatchDAO.get(id);
                if (d == null) System.out.println("Not found");
                else {
                    d.setDeliveredDate(del);
                    d.setStatus("DELIVERED");
                    dispatchDAO.update(d);
                    System.out.println("Updated");
                }
            }

            else if (ch == 10) {
                System.out.print("Warehouse ID: ");
                int wid = sc.nextInt(); sc.nextLine();
                System.out.print("From Date (YYYY-MM-DD): ");
                LocalDate f = LocalDate.parse(sc.nextLine());
                System.out.print("To Date (YYYY-MM-DD): ");
                LocalDate t = LocalDate.parse(sc.nextLine());
                List<Object[]> r = stockDAO.inboundOutboundTrend(wid, f, t);
                System.out.println("\nDate | IN Qty | OUT Qty");
                for (Object[] x : r) {
                    System.out.println(x[0] + " | " + x[1] + " | " + x[2]);
                }
            }

            else if (ch == 11) {
                System.out.print("Month: ");
                int m = sc.nextInt();
                System.out.print("Year: ");
                int y = sc.nextInt(); sc.nextLine();
                List<Object[]> r = salesOrderDAO.monthlyRevenue(m, y);
                System.out.println("\nWarehouse | Revenue");
                for (Object[] x : r) {
                    System.out.println(x[0] + " | " + x[1]);
                }
            }

            else if (ch == 12) {
                System.out.print("Warehouse ID: ");
                int wid = sc.nextInt(); sc.nextLine();
                System.out.print("From (YYYY-MM-DD): ");
                LocalDate f = LocalDate.parse(sc.nextLine());
                System.out.print("To (YYYY-MM-DD): ");
                LocalDate t = LocalDate.parse(sc.nextLine());
                List<Object[]> r = dispatchDAO.lateDeliveries(wid, f, t);
                System.out.println("\nDispatch | Order | Promised | Delivered | Courier");
                for (Object[] x : r) {
                    System.out.println(x[0] + " | " + x[1] + " | " + x[2] + " | " + x[3] + " | " + x[4]);
                }
            }

            else if (ch == 13) {
                System.out.print("Cutoff (YYYY-MM-DD): ");
                LocalDate c = LocalDate.parse(sc.nextLine());
                int rows = returnDAO.bulkCloseOld(c);
                System.out.println("Closed rows = " + rows);
            }

            else if (ch == 14) {
                warehouseDAO.list().forEach(w -> System.out.println(w.getName()));
            }

            else if (ch == 15) {
                productDAO.list().forEach(p -> System.out.println(p.getName()));
            }

            else if (ch == 16) {
                binDAO.list().forEach(b -> System.out.println(b.getCode()));
            }

            else if (ch == 17) {
                customerDAO.list().forEach(cu -> System.out.println(cu.getName()));
            }

            else if (ch == 18) {
                supplierDAO.list().forEach(sp -> System.out.println(sp.length));
            }

            else if (ch == 19) {
                stockDAO.list().forEach(l -> System.out.println(l.getMovementType()+" "+l.getQty()));
            }

            else if (ch == 20) {
                System.out.println("Bye");
                break;
            }
        }

        sc.close();
    }
}
