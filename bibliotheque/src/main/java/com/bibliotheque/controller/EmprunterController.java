package com.bibliotheque.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bibliotheque.dao.ExemplaireDAO;
import com.bibliotheque.service.ExemplaireService;

@Controller
@RequestMapping(value = "/emprunter")
public class EmprunterController {
	
	@Autowired
	ExemplaireDAO exemplaireDAO;
	//ExemplaireService exemplaireService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	//public String GetMethod(@RequestParam String prenom, Model model) {	
	public String ListeDesTaches(HttpServletRequest request, Model model) {			
		//model.addAttribute("prenom", prenom);		
//		model.addAttribute("liste", listeAFaireService.recupererListe("Mes élèves"));				
		model.addAttribute("liste", exemplaireDAO.findAll());
		return "exemplaire-liste";
	}

}
