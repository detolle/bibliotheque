package com.bibliotheque.service;

import java.util.List;

import com.bibliotheque.entity.Exemplaire;

public interface IExemplaireService {
	Exemplaire findByKey(Integer id);
	List<Exemplaire> findAll();
	void insert(Exemplaire exemplaire);
	void update(Exemplaire exemplaire);
	void delete(Integer id);
}
