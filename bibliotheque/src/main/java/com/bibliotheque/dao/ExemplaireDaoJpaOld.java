package com.bibliotheque.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.bibliotheque.entity.Exemplaire;
import com.bibliotheque.entity.Livre;
import com.bibliotheque.util.EntityManagerHolder;
import com.bibliotheque.util.EnumStatusExemplaire;


@Service
public class ExemplaireDaoJpaOld {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static List<Exemplaire> listeExemplaire = new ArrayList<>();
	//private static List<Livre> listeLivre = new ArrayList<>();
	

	public Exemplaire findByKey(Integer id) {
		EntityManager em=null;	
		EntityTransaction tx = null;
		Exemplaire exemplaire=null;		

		try {
			em = new EntityManagerHolder().getCurrentEntityManager();
			tx = em.getTransaction();
			tx.begin();
			exemplaire=em.find(Exemplaire.class, id);	
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) tx.rollback();
		} finally {
			if (em!=null) em.close();
		}		
		return exemplaire;
	}	
	
	public List<Exemplaire> findAll() {
		EntityManager em=null;	
		EntityTransaction tx = null;
		Query query=null;

		try {
			em = new EntityManagerHolder().getCurrentEntityManager();
			tx = em.getTransaction();
			tx.begin();
			query = em.createQuery("select e from Exemplaire e order by e.isbn");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) tx.rollback();
		} finally {
			if (em!=null) em.close();
		}		
		return query.getResultList();
    	//Query<Epreuve> query=em.createQuery("select e from Exemplaire e join fetch e.tournoi where e.tournoi.code=?0", Epreuve.class);
    	//Query<Exemplaire> query=em.createQuery("select e from Exemplaire", Exemplaire.class);
    	//query.setParameter(0, codeTournoi);
    	//List<Exemplaire> exemplaires=query.getResultList();		
		//return exemplaires;
		//return null;
	}	
	
	public void insert(Exemplaire exemplaire) {
		EntityManager em=null;	
		EntityTransaction tx = null;	
		
		try {
			em = new EntityManagerHolder().getCurrentEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.persist(exemplaire);	
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) tx.rollback();
		} finally {
			if (em!=null) em.close();
		}				
	}	
	
	public Boolean updateStatus(Exemplaire exemplaire) {
		return false;
	}

	public Boolean update(Exemplaire exemplaire) {
		EntityManager em=null;	
		EntityTransaction tx = null;	
		
		try {
			em = new EntityManagerHolder().getCurrentEntityManager();
			tx = em.getTransaction();
			tx.begin();
			em.merge(exemplaire);	
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) tx.rollback();
		} finally {
			if (em!=null) em.close();
		}				
		return false;		
	}
	
	public Boolean delete(Integer id) {
		EntityManager em=null;	
		EntityTransaction tx = null;	
		Exemplaire exemplaire=null;
		
		try {
			em = new EntityManagerHolder().getCurrentEntityManager();
			tx = em.getTransaction();
			tx.begin();
			exemplaire=em.find(Exemplaire.class, id);				
			em.remove(exemplaire);	
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx!=null) tx.rollback();
		} finally {
			if (em!=null) em.close();
		}			
		return false;		
	}
		
	
}
