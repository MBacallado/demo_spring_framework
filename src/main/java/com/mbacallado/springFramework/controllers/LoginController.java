package com.mbacallado.springFramework.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbacallado.springFramework.entity.User;
import com.mbacallado.springFramework.services.LoginService;

@Controller
public class LoginController {
	
	private static final String LOGIN_VIEW = "login";

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	private static final String TAG = LoginController.class.getSimpleName();
	
	@Autowired
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	
	/**
	 * Method that redirects to the login method
	 * @return
	 */
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("call: " + TAG + " redirectToLogin()");
		return "redirect:/login";
	}
	
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
		model.addAttribute("user", new User());
		return LOGIN_VIEW;
	}
	
	/**
	 * method that checks the credentials and redirects to the corresponding view
	 * @param user
	 * @return
	 */
	@PostMapping("/checkCredentials")
	public String checkUser(@ModelAttribute("user") User user) {
		LOG.info("call: " + TAG + " checkCredentials()");
		return loginService.checkUser(user) ? "redirect:/movies/all" : "redirect:/login?error";
	}
}
