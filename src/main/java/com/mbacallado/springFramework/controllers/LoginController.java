package com.mbacallado.springFramework.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private static final String LOGIN_VIEW = "login";

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	private static final String TAG = LoginController.class.getSimpleName();
	
	/**
	 * Method that redirects to the login html 
	 * @param model
	 * @param error
	 * @param logout
	 * @return
	 */
	@GetMapping("/login")
	public String showForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		LOG.info("call: " + TAG + " showForm()");
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return LOGIN_VIEW;
	}
	
	/**
	 * method that checks the credentials and redirects to the corresponding view
	 * @param user
	 * @return
	 */
	@GetMapping({"/loginsuccess", "/"})
	public String checkUser() {
		LOG.info("call: " + TAG + " checkCredentials()");
		return "redirect:/movies/all";
	}
}
