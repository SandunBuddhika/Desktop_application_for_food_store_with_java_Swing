package com.sandun.web.service;

import com.sandun.web.entities.Message;
import com.sandun.web.entities.OrderManager;
import com.sandun.web.entities.enums.MessageType;
import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.utill.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MessageService {

    public List<Message> getChatByOrderId(long id) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createNamedQuery("loadChat", Message.class).setParameter("oId", id).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public List<OrderManager> getOrderHandlers(OrderState state, long uId) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createNamedQuery("getOrderhandlers", OrderManager.class).setParameter("uId", uId).setParameter("oState", state).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public void setMessage(OrderManager handler, MessageType type, String msg) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();
            Message m = new Message();
            m.setMessage(msg);
            m.setType(type);
            m.setOrder(handler);
            m.setDate(new Date());
            s.persist(m);
            t.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getChatSizeByOrderId(long id) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createNamedQuery("loadChatSize", Long.class).setParameter("oId", id).getSingleResult();
        } catch (Exception e) {
            return 0L;
        }
    }
}
