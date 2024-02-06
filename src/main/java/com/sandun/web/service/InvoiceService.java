package com.sandun.web.service;

import com.sandun.web.dto.ExtraIngredientDTO;
import com.sandun.web.dto.FoodDTO;
import com.sandun.web.entities.ExtraIngredient;
import com.sandun.web.entities.Food;
import com.sandun.web.entities.Invoice;
import com.sandun.web.entities.InvoiceItem;
import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.model.SessionManager;
import com.sandun.web.utill.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InvoiceService {

    public boolean checkOut(List<FoodDTO> order) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();
            FoodService foodService = new FoodService();
            double total = 0;
            Invoice invoice = new Invoice();
            List<InvoiceItem> invoiceItems = new ArrayList<>();
            for (FoodDTO dto : order) {
                InvoiceItem invoiceItem = new InvoiceItem();
                try {
                    Food f = foodService.getFoodItemById(dto.getId());
                    if (f != null) {
                        total += dto.getPrice();
                        Set<ExtraIngredient> extraIngredients = invoiceItem.getInvoiceIngredients();
                        for (ExtraIngredientDTO ingredientDTO : dto.getExtraIngredients()) {
                            total += ingredientDTO.getPrice();
                            ExtraIngredient ei = foodService.getExtraIngredientById(ingredientDTO.getId());
                            extraIngredients.add(ei);
                        }
                        invoiceItem.setFood(f);
                        invoiceItem.setInvoice(invoice);
                        invoiceItem.setQty(dto.getQty());
                        invoiceItems.add(invoiceItem);
                    }
                } catch (Exception ex) {
                    System.out.println("INVOICE EXCEPTION: AT " + dto.getId());
                }
            }
            invoice.setItems(invoiceItems);
            invoice.setDate(new Date());
            invoice.setUser(SessionManager.getUSER());
            invoice.setTotal(total);
            s.persist(invoice);
            t.commit();
            return true;
        } catch (Exception e) {
            System.out.println("Error At Checkout, ERROR");
            e.printStackTrace();
            return false;
        }
    }

    public List<Invoice> getAllInvoice() {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            List<Invoice> invoices = s.createNamedQuery("getAllInvoices", Invoice.class).getResultList();

            return invoices;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Invoice getInvoiceById(long id) {
        try ( Session s = HibernateUtil.getSessionFactory().openSession()) {
            return s.createNamedQuery("getInvoiceById", Invoice.class).setParameter("iId", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
