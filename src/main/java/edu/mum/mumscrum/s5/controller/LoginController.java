package edu.mum.mumscrum.s5.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
//	@Autowired
//	private LoginService loginService;
	
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@ModelAttribute("user") User user) {
//		LOGGER.debug("Processing request for /login");
//		
//		boolean validUser = this.loginService.login(user);
//		
//	}	
	
	@RequestMapping(value = { "/login" })
	public String loginPage(Map<String, Object> map,
			@RequestParam(value = "logout", required = false) String logout,
			@RequestParam(value = "error", required = false) String error) {

		if (logout != null) {

			map.put("logoutSuccessful", "You've been logged out successfully.");
		}

		if (error != null) {

			map.put("error", "Invalid username and/or password!");
		}

		return "/login";
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(Map<String, Object> map) {

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			map.put("username", userDetail.getUsername());

		}

		return "/403";
	}

	@RequestMapping(value = { "/", "/dashboard**" }, method = RequestMethod.GET)
	public String defaultPage(Map<String, Object> map) {

		map.put("title", "Spring Security Login Form - Database Authentication");
		map.put("message", "This is default page!");

		return "/dashboard";
	}
}
