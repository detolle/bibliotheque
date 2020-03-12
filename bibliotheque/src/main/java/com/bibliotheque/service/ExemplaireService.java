package com.bibliotheque.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotheque.dao.ExemplaireDaoJpa;
import com.bibliotheque.entity.Exemplaire;


@Service
public class ExemplaireService {
	
	@Autowired
	private ExemplaireDaoJpa dao;

	@Transactional(readOnly=true)
	public Exemplaire findByKey(BigDecimal id) {
		return dao.findByKey(id);
	}	
	@Transactional(readOnly=true)
	public List<Exemplaire> findAll() {
		return dao.findAll();
	}	

	@Transactional
	public void insert(Exemplaire exemplaire) {	
		dao.insert(exemplaire);
	}
	@Transactional
	public void update(Exemplaire exemplaire) {
		dao.update(exemplaire);
	}	
	@Transactional
	public void delete(BigDecimal id) {
		dao.delete(id);
	}	
	
}
