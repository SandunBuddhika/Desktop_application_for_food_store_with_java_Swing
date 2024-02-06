package com.sandun.web.service;

import com.sandun.web.entities.ExtraIngredient;
import com.sandun.web.entities.Food;
import com.sandun.web.utill.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class FoodService {

    public List<Food> getAllFoodItems() {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Food> list;
            list = session.createNamedQuery("getAll", Food.class).getResultList();
            return list;
        } catch (Exception e) {
            System.out.println("Error At Getting All Food Items, ERROR" + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Food getFoodItemById(long id) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            Food f = session.get(Food.class, id);
            return f;
        } catch (Exception e) {
            System.out.println("Error At Getting Food By Id, ERROR" + e.getMessage());
            return null;
        }
    }

    public ExtraIngredient getExtraIngredientById(long id) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            ExtraIngredient e = session.get(ExtraIngredient.class, id);
            return e;
        } catch (Exception e) {
            System.out.println("Error At Getting ExtraIngredient By Id, ERROR" + e.getMessage());
            return null;
        }
    }

    public ExtraIngredient getExtraIngredientByName(char customCode, double price) {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            ExtraIngredient e = session.createNamedQuery("getCustomIngredient", ExtraIngredient.class).setParameter("eName", customCode + "%").setParameter("ePrice", price).getSingleResult();
            return e;
        } catch (Exception e) {
            System.out.println("Error At Getting ExtraIngredient By Id, ERROR" + e.getMessage());
            return null;
        }
    }
}
