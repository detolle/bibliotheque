package com.bibliotheque.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.entity.Exemplaire;
import com.bibliotheque.util.EnumStatusExemplaire;


@Repository
public class ExemplaireDaoJpa {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Exemplaire findByKey(BigDecimal id) {
		Exemplaire exemplaire=null;		
		exemplaire=entityManager.find(Exemplaire.class, id);	
		return exemplaire;
	}	
	
	public List<Exemplaire> findAll() {
		Query query=entityManager.createQuery("select e from Exemplaire e order by e.isbn");
		return query.getResultList();
    	//Query<Epreuve> query=em.createQuery("select e from Exemplaire e join fetch e.tournoi where e.tournoi.code=?0", Epreuve.class);
    	//query.setParameter(0, codeTournoi);
    	//List<Exemplaire> exemplaires=query.getResultList();		
		//return exemplaires;
		//return null;
	}	
	
	public void insert(Exemplaire exemplaire) {
		Exemplaire exemplaireNew=new Exemplaire();
		exemplaireNew.setDateAchat(exemplaire.getDateAchat());	
		exemplaireNew.setStatus(exemplaire.getStatus());			
		exemplaireNew.setIsbn(exemplaire.getIsbn());
System.out.println(exemplaireNew);		
		entityManager.persist(exemplaireNew);
	}		
//	public void updateStatus(Exemplaire exemplaire) {
//	}

	public void update(Exemplaire exemplaire) {
		entityManager.merge(exemplaire);						
	}
	
	public void delete(BigDecimal id) {
		Exemplaire exemplaire=null;
		exemplaire=entityManager.find(Exemplaire.class, id);				
		entityManager.remove(exemplaire);		
	}
		
	
}
