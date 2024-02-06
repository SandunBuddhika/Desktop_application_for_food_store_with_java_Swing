package com.sandun.web.utill;

import com.sandun.web.entities.Invoice;
import com.sandun.web.entities.enums.OrderState;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        System.out.println(s.createQuery("select count(u.id) from User u",Long.class).getSingleResult());
    }
}
