package edu.mum.mumscrum.s5.controller;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.service.UserService;

@SessionAttributes({"role", "loggedInEmployee"})
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
			@RequestParam(value = "error", required = false) String error, WebRequest request, HttpSession session, SessionStatus status) {

		if (logout != null) {
			
			status.setComplete();
			request.removeAttribute("role", WebRequest.SCOPE_SESSION);
			request.removeAttribute("loggedInEmployee", WebRequest.SCOPE_SESSION);
			
//			session.removeAttribute("role");
//			session.removeAttribute("loggedInEmployee");

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
	public String defaultPage(Map<String, Object> map, HttpSession session) {
		
		User activeUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Currently logged in user is: " + activeUser.getUsername());
		
        edu.mum.mumscrum.s5.entity.User user = userService.getUserByUserName(activeUser.getUsername());
        
        map.put("loggedInEmployee", user.getEmployee());
		
		
		
		Collection<GrantedAuthority> authorities = getAuthorities();
        String rolename;
         
        for (GrantedAuthority authority : authorities) {
            rolename = authority.getAuthority();
            session.setAttribute("role", rolename);
            session.setAttribute("loggedInEmployee", user.getEmployee());
            if (rolename.equals("Developer")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                Employee emp = user.getEmployee();
                map.put("assignedUserStories", emp.getUserStoriesForDeveloper());
                map.put("page", "main-developer");
            }
            if (rolename.equals("Tester")) {
            	Employee emp = user.getEmployee();
            	map.put("assignedUserStories", emp.getUserStoriesForTester());
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                map.put("page", "main-tester");
            }
            if (rolename.equals("Scrum Master")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                map.put("page", "main-scrum-master");
            }
            
            if (rolename.equals("Product Owner")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                map.put("page", "main-product-owner");
            }
            if (rolename.equals("HR ADMIN")) {
                LOGGER.debug("Directing to home page for: [" + rolename + "]");
                map.put("page", "main-hr-admin");
            }
            
        }
         System.out.println("ROLE IS: " + session.getAttribute("role"));
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
