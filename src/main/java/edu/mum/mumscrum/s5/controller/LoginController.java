package edu.mum.mumscrum.s5.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.service.UserService;


@Controller
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
	
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
		
		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Currently logged in user is: " + activeUser.getUsername());
		
        edu.mum.mumscrum.s5.entity.User user = userService.getUserByUserName(activeUser.getUsername());
        
        map.put("loggedInEmployee", user.getEmployee());
		map.put("page", "main");
		
		
		Collection<GrantedAuthority> authorities = getAuthorities();
        String rolename;
         
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
            map.put("role", rolename);
            if (rolename.equals("Developer")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                
                return "dashboard-tester";
            }
            if (rolename.equals("Tester")) {
            	Employee emp = user.getEmployee();
            	System.out.println(emp.getUserStoriesForTester());
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                return "dashboard-tester";
            }
            if (rolename.equals("Scrum Master")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                return "dashboard-scrum";
            }
            
            if (rolename.equals("Product Owner")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                return "dashboard-product-owner";
            }
            if (rolename.equals("HR ADMIN")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                return "dashboard";
            }
            
            
        }
         
        LOGGER.error("Role not found - directing to home page for ROLE_USER");
        
		return "/dashboard";
	}
	
	private Collection<GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof User) {
            authorities = ((User) principal).getAuthorities();
        } else {
            LOGGER.error("Principal is not an instance of com.dtr.oas.model.User");
        }
        return authorities;
    }
}
