package com.bibliotheque.controller;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bibliotheque.dao.ExemplaireDAO;
import com.bibliotheque.dao.ExemplaireDaoJpa;
import com.bibliotheque.entity.Exemplaire;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.util.CaseInsensitiveConverter;
import com.bibliotheque.util.EnumStatusExemplaire;


@Controller
@RequestMapping(value = "/exemplaire")
public class ExemplaireController {
	
	@Autowired
	ExemplaireService exemplaireService;
	//ExemplaireDAO exemplaireDAO;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		//binder.registerCustomEditor(EnumStatusExemplaire.class, new CaseInsensitiveConverter<>(EnumStatusExemplaire.class));

//		binder.registerCustomEditor(EnumStatusExemplaire.class, new PropertyEditorSupport() {
//			@Override
//			public void setAsText(String value) throws IllegalArgumentException {
//				if(StringUtils.isBlank(value))
//					return;
//	
//				setValue(EnumStatusExemplaire.valueOf(value));
//			}
//	
//			@Override
//			public String getAsText() {
//				if(getValue() == null)
//					return "";
//
//				return ((EnumStatusExemplaire) getValue()).name();
//			}
//		});		
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String root() {
//		return "redirect:liste";
//	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	//public String Liste(@RequestParam String prenom, Model model) {	
	//public String Liste(HttpServletRequest request, Model model) {
	public String Liste(Model model) {
		model.addAttribute("liste", exemplaireService.findAll());
		return "exemplaire-liste";
	}

	@RequestMapping(value = "/ins", method = RequestMethod.GET)
	public String InsG(Model model) {	
		Exemplaire exemplaire=new Exemplaire(null, new Date(), EnumStatusExemplaire.DISPONIBLE.getValue(), "");
		model.addAttribute("action", "ins");
		model.addAttribute("exemplaire", exemplaire);
		return "exemplaire-form";
	}
	
	@RequestMapping(value = "/ins", method = RequestMethod.POST)
	public String InsP(@Valid @ModelAttribute("exemplaire") Exemplaire exemplaire,
						BindingResult result) {

		if(result.hasErrors()) {			
			return "exemplaire-form";
		}
//System.out.println("Ctrl:"+exemplaire);			
		exemplaireService.insert(exemplaire);
		return "redirect:liste";
	}
	
	@RequestMapping(value = "/upd", method = RequestMethod.GET)
	//public String GetMethod(@RequestParam String prenom, Model model) {	
	public String UpdG(@RequestParam BigDecimal id, Model model) {			
		Exemplaire exemplaire=exemplaireService.findByKey(id);
		model.addAttribute("action", "upd");
		model.addAttribute("exemplaire", exemplaire);
System.out.println("Ctrl:"+exemplaire);		
		return "exemplaire-form";
	}	
	
	@RequestMapping(value = "/upd", method = RequestMethod.POST)
	public String UpdP(HttpServletRequest request, 
			@Valid @ModelAttribute("exemplaire") Exemplaire exemplaire,
			BindingResult result) {
		
		if(result.hasErrors()) {	
			return "exemplaire-form";
		}	
System.out.println("CtrlPost:"+exemplaire);		
		exemplaireService.update(exemplaire);
		
		return "redirect:liste";
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String Supprimer(@RequestParam BigDecimal id) {
		
		//throw new RuntimeException("mon erreur");
		exemplaireService.delete(id);
		
		return "redirect:liste";
	}
	
}
