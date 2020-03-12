package com.bibliotheque.test;

import java.util.List;

import com.bibliotheque.dao.ExemplaireDaoJpa;
import com.bibliotheque.entity.Exemplaire;

public class TestConnection {
	public static void main(String[] args) {
		ExemplaireDaoJpa exemplaireDaoJpa= new ExemplaireDaoJpa();
		
		List<Exemplaire> exemplaires=exemplaireDaoJpa.findAll();	
		for(Exemplaire exemplaire : exemplaires) {
			System.out.println(exemplaire);
		}

	}
}
