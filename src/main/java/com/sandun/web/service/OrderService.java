package com.sandun.web.service;

import com.sandun.web.entities.Invoice;
import com.sandun.web.entities.OrderManager;
import com.sandun.web.entities.User;
import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.model.SessionManager;
import com.sandun.web.utill.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderService {

    private User user;

    public OrderService() {
        user = SessionManager.getUSER();
    }

    public List<OrderManager> getAllOrder() {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createNamedQuery("getAllOrdershandlers", OrderManager.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void takeTheOrder(long invoiceId) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();
            OrderManager om = new OrderManager();
            om.setHandler(s.get(User.class, user.getId()));
            om.setOrder(s.get(Invoice.class, invoiceId));
            om.setState(OrderState.PREPARING);
            s.persist(om);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean changeTheOrderState(long orderid, OrderState state) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            OrderManager om = s.get(OrderManager.class, orderid);
            if (om != null) {
                Transaction t = s.beginTransaction();
                om.setState(state);
                s.merge(om);
                t.commit();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<OrderManager> getAllOrders(OrderState state) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createNamedQuery("getAllOrders", OrderManager.class).setParameter("oState", state).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
