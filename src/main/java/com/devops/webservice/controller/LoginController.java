package com.devops.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devops.webservice.model.UserCredentials;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class LoginController {

	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredentials());
		return "login";
	}

	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "UserCredentials") UserCredentials credentials) {
		if (credentials.getName().equals("root") && credentials.getPassword().equals("root")) {
			return "redirect:/contacts/showcontacts";
		}
		return "redirect:/login?error";
	}
}
