package com.mbacallado.springFramework.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mbacallado.springFramework.entity.User;
import com.mbacallado.springFramework.services.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	private static final String TAG = LoginController.class.getSimpleName();
	
	@Autowired
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	
	@PostMapping("/checkCredentials")
	public String checkUser(@ModelAttribute("user") User user) {
		LOG.info("call: " + TAG + " checkCredentials()");
		return loginService.checkUser(user) ? "redirect:/movies/all" : "redirect:/login/showform";
	}
}
