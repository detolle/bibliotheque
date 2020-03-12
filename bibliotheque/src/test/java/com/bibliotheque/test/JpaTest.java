package com.bibliotheque.test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bibliotheque.entity.Exemplaire;
import com.bibliotheque.util.EnumStatusExemplaire;
 
public class JpaTest {
    private static EntityManager em;
 
    public static void main(String[] args) {
 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSIST_UNIT");
        em = emf.createEntityManager();
 
        createExemplaire(1, new Date(), EnumStatusExemplaire.DISPONIBLE, "Titre1");
        createExemplaire(2, new Date(), EnumStatusExemplaire.DISPONIBLE, "Titre2");

    }
 
    private static void createExemplaire(int id, Date date, EnumStatusExemplaire status, String isbn) {
        em.getTransaction().begin();
        //Exemplaire emp = new Exemplaire(id, date, status, isbn);
        Exemplaire emp = new Exemplaire();
        emp.setDateAchat(date);
        emp.setStatus(status);
        emp.setIsbn(isbn);
        em.persist(emp);
        em.getTransaction().commit();
    }
}