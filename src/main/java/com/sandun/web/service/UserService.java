package com.sandun.web.service;

import com.sandun.web.entities.User;
import com.sandun.web.entities.enums.UserType;
import com.sandun.web.utill.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public User logIn(String username, String password) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (password.isBlank()) {
                User u = session.createNamedQuery("logInByUsername", User.class).setParameter("uUsername", username).getSingleResult();
                return u;
            } else {
                User u = session.createNamedQuery("logIn", User.class).setParameter("uUsername", username).setParameter("uPassword", password).getSingleResult();
                return u;
            }
        } catch (Exception e) {
            System.out.println("Error At Getting User By Id, ERROR" + e.getMessage());
            return null;
        }
    }

    public User createNewUser(String username) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            User u = new User();
            u.setType(UserType.CUSTOMER);
            u.setUsername(username);
            u.setDate(new Date());
            session.persist(u);
            t.commit();
            return u;
        } catch (Exception e) {
            System.out.println("Error At Getting User By Id, ERROR" + e.getMessage());
            return null;
        }
    }
}
