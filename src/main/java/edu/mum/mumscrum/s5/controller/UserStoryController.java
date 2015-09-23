package edu.mum.mumscrum.s5.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.Role;
import edu.mum.mumscrum.s5.entity.User;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.service.ProductBacklogService;
import edu.mum.mumscrum.s5.service.ReleaseBacklogService;
import edu.mum.mumscrum.s5.service.RoleService;
import edu.mum.mumscrum.s5.service.SprintService;
import edu.mum.mumscrum.s5.service.UserService;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Controller
public class UserStoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryController.class);

	@Autowired
	private ReleaseBacklogService releaseBacklogService;

	@Autowired
	private ProductBacklogService productBacklogService;

	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SprintService springService;
	//
	// @Autowired
	// private ReleaseBacklogService releaseBacklogService;

	@RequestMapping(value = "/userstory", method = RequestMethod.GET)
	public String listUserStories(Model model) {
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/userstory/save", method = RequestMethod.POST)
	public String saveUserStory(@PathVariable("productBacklogId") int id,
			@ModelAttribute("userstory") UserStory userStory,
			BindingResult result, RedirectAttributes redir) {

		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(id);

		userStory.setProductBacklog(productBacklog);
		
		if(userStory.getId() == 0) {
			userStoryService.addUserStory(userStory);
		}
		else {
			userStoryService.updateUserStory(userStory);
		}
		
		

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/productbacklog/" + id;
	}
	

	@RequestMapping(value = "productbacklog/{productBacklogId}/userstory/{userStoryId}/edit")
	public String editUserStory(@PathVariable int userStoryId, @PathVariable int productBacklogId, Model model) {
		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(productBacklogId);
		if(productBacklog.getUserStories().size() > 0) {
			model.addAttribute("userStoryList", productBacklog.getUserStories());
		}
		if(productBacklog.getReleases().size() > 0) {
			model.addAttribute("releaseBacklogList", productBacklog.getReleases());
		}
		
		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		Release releaseBacklog = new Release();
		model.addAttribute("buttonTitle", "Edit");
		model.addAttribute("userstory", userStory);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("productbacklog", productBacklog);
		model.addAttribute("page", "productBacklog/productBacklogDetails");

		return "dashboard";
	}
	
	@RequestMapping(value = "productbacklog/{productBacklogId}/userstory/{userStoryId}/delete")
	public String removeUserStory(@PathVariable int userStoryId, @PathVariable int productBacklogId) {
		
//		try {
//			this.userStoryService.removeUserStory(userStoryId);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//			return "error";
//		}
		
		this.userStoryService.removeUserStory(userStoryId);

		return "redirect:/productbacklog/" + productBacklogId;
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/userstory/{userStoryId}/assign/developer")
	public String assignDeveloper(@PathVariable int productBacklogId, @PathVariable int releaseBacklogId, @PathVariable int sprintId, @PathVariable int userStoryId, Model model) {
		List<User> developers = new ArrayList<User>();
		developers.clear();
		for (Role role : roleService.getRoles()) {
			if(role.getRole().equals("Developer")) {
				for (User user : role.getUserRoles()) {
					developers.add(user);
				}
			}
		}
		
		
		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		
		if(userStory.getDeveloper() != null) {
			model.addAttribute("assignedEmployee", userStory.getDeveloper());
		}
		
		model.addAttribute("developers", developers);
		model.addAttribute("page", "sprint/assignDeveloper");
		model.addAttribute("userstory", userStory);
		
		
//		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}";
		return "dashboard";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/userstory/{userStoryId}/assign/tester")
	public String assignTester(@PathVariable int productBacklogId, @PathVariable int releaseBacklogId, @PathVariable int sprintId, @PathVariable int userStoryId, Model model) {
		List<User> testers = new ArrayList<User>();
		testers.clear();
		for (Role role : roleService.getRoles()) {
			if(role.getRole().equals("Tester")) {
				for (User user : role.getUserRoles()) {
					testers.add(user);
				}
			}
		}
		
		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		model.addAttribute("testers", testers);
		model.addAttribute("page", "sprint/assignTester");
		model.addAttribute("userstory", userStory);
		
		
//		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}";
		return "dashboard";
	}
	
	@RequestMapping(value= "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/userstory/{userStoryId}/assign/developer", method = RequestMethod.POST)
	public String assignUserStoryToDeveloper(@PathVariable int productBacklogId, @PathVariable int releaseBacklogId,
			@PathVariable int sprintId, @PathVariable int userStoryId,
			@ModelAttribute("userId") int userId){
		
		Employee employee = null;
		
		if(userId != 0) {
			User user = userService.getUserById(userId);
			employee = user.getEmployee();
		}
		
		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		
		userStory.setDeveloper(employee);
		
		userStoryService.updateUserStory(userStory);
		
		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/";
		
	}
	
	@RequestMapping(value= "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/userstory/{userStoryId}/assign/tester", method = RequestMethod.POST)
	public String assignUserStoryToTester(@PathVariable int productBacklogId, @PathVariable int releaseBacklogId,
			@PathVariable int sprintId, @PathVariable int userStoryId,
			@ModelAttribute("userId") int userId){
		
		Employee employee = null;
		
		if(userId != 0) {
			User user = userService.getUserById(userId);
			employee = user.getEmployee();
		}
		
		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		
		userStory.setTester(employee);
		
		userStoryService.updateUserStory(userStory);
		
		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/";
		
	}

}
