package com.bibliotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/")
	public String pageIndex() {
//System.out.println("=>/");		
		return "redirect:exemplaire/liste"; 		//"index";	//"accueil";
	}	

//	@RequestMapping("/hello")
//	public String pageAccueil() {
//		return "accueil";	//"accueil";
//	}	
	
	@RequestMapping(value = "/welcomespring") 
    @ResponseBody 
    public String welcome() { 
       return "Welcome to Spring MVC"; 
    }


}
