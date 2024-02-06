package com.sandun.web.service;

import com.sandun.web.entities.User;
import com.sandun.web.utill.HibernateUtil;
import org.hibernate.Session;

public class UserService {

    public User getUserById(long id) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            User u = session.get(User.class, id);
            return u;
        } catch (Exception e) {
            System.out.println("Error At Getting User By Id, ERROR" + e.getMessage());
            return null;
        }
    }
}
