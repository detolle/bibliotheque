package com.bibliotheque.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionControlleur {
	private Log logger= LogFactory.getLog(ExceptionControlleur.class);
	
	@ExceptionHandler(value=Exception.class)
	public String handleError(HttpServletRequest request, Exception exception, Model model) {
		logger.error("Request: "+request.getRequestURL()+" "+exception);
		model.addAttribute("error", "<b>Request: "+request.getRequestURL()+"</b><br> "+exception);
		return "error";
	}

}
