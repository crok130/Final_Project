package com.sweetpotato.community;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
	
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	
	@RequestMapping(value = "profile", method = RequestMethod.GET)
	public String profile() {
		return "profile";
	}
	
	
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public String mypage() {
		return "mypage";
	}
}
