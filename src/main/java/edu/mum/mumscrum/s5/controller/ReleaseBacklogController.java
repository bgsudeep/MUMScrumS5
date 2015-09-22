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
import edu.mum.mumscrum.s5.entity.Sprint;
import edu.mum.mumscrum.s5.entity.User;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.service.ProductBacklogService;
import edu.mum.mumscrum.s5.service.ReleaseBacklogService;
import edu.mum.mumscrum.s5.service.RoleService;
import edu.mum.mumscrum.s5.service.SprintService;
import edu.mum.mumscrum.s5.service.UserService;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Controller

public class ReleaseBacklogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseBacklogController.class);

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
	private SprintService sprintService;
	//
	// @Autowired
	// private ReleaseBacklogService releaseBacklogService;

	@RequestMapping(value = "/releasebacklog", method = RequestMethod.GET)
	public String listReleaseBacklogs(Model model) {
		LOGGER.debug("Processing request for /releasebacklog");
		model.addAttribute("releasebacklog", new Release());
		model.addAttribute("page", "releaseBacklog/releasebacklog");
		model.addAttribute("productBacklogList", this.productBacklogService.listProductBacklog());
		return "dashboard";
	}
	
	
	@RequestMapping(value = "productbacklog/{productBacklogId}/releasebacklog/add", method = RequestMethod.POST)
	public String addRelease(@PathVariable("productBacklogId") int id,
			@ModelAttribute("releasebacklog") Release releaseBacklog,
			BindingResult result, RedirectAttributes redir) {

		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(id);

		releaseBacklog.setProductBacklog(productBacklog);
		releaseBacklogService.addRelease(releaseBacklog);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/productbacklog/" + id;
	}
	
	@RequestMapping(value = "productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/delete", method = RequestMethod.GET)
	public String removeRelease(@PathVariable int productBacklogId, @PathVariable int releaseBacklogId) {

		Release r = releaseBacklogService.getReleaseById(releaseBacklogId);
		
		ProductBacklog productBacklog = r.getProductBacklog();
		
		productBacklog.getReleases().remove(r);
		
		productBacklogService.updateProductBacklog(productBacklog);		
//		releaseBacklogService.removeRelease(releaseBacklogId);

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/productbacklog/" + productBacklogId;
	}
	
	@RequestMapping(value = "/releasebacklog/{releaseBacklogId}/assign", method = RequestMethod.GET)
	public String assignReleaseBacklog(@PathVariable int releaseBacklogId, Model model) {
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		List<User> scrumMasters = new ArrayList<User>();
		scrumMasters.clear();
		for (Role role : roleService.getRoles()) {
			if(role.getRole().equals("Scrum Master")) {
				for (User user : role.getUserRoles()) {
					scrumMasters.add(user);
				}
			}
		}
		model.addAttribute("scrummasters", scrumMasters);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("page", "releaseBacklog/assignReleaseBacklog");
		
		return "dashboard";
	}
	
	@RequestMapping(value= "/releasebacklog/{releaseBacklogId}/assign", method = RequestMethod.POST)
	public String assignReleaseBacklogToScrumMaster(@PathVariable int releaseBacklogId,
			@ModelAttribute("userId") int userId){
		
		Employee employee = null;
		
		if(userId != 0) {
			User user = userService.getUserById(userId);
			employee = user.getEmployee();
		}
		
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		
		releaseBacklog.setEmployee(employee);
		
		releaseBacklogService.updateRelease(releaseBacklog);
		
		return "redirect:/releasebacklog/";
		
	}

	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintID}/edit", method = RequestMethod.GET)
	public String getReleaseBacklogDetails(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @PathVariable int sprintID,
			Model model) {
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(productBacklogId);
		
		if (this.productBacklogService.getAvailableUserStories(productBacklog).size() > 0) {
			model.addAttribute("availableUserStories", productBacklogService.getAvailableUserStories(productBacklog));
		}

		if (releaseBacklog.getUserStories().size() > 0) {
			model.addAttribute("userStoryList", releaseBacklog.getUserStories());
		}
		
		if (releaseBacklog.getSprints().size() > 0) {
			model.addAttribute("sprintList", releaseBacklog.getSprints());
		}
		

		UserStory userStory = new UserStory();
		Sprint sprint = sprintService.getSprintById(sprintID);
		model.addAttribute("userstory", userStory);
		model.addAttribute("productbacklog", productBacklog);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("sprint", sprint);
		model.addAttribute("buttonTitle", "Edit");
		model.addAttribute("page", "releaseBacklog/releaseBacklogDetails");

		return "dashboard";
	}
	
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}", method = RequestMethod.GET)
	public String getReleasebacklogDetails(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId,Model model) {
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(productBacklogId);
		
		if (this.productBacklogService.getAvailableUserStories(productBacklog).size() > 0) {
			model.addAttribute("availableUserStories", productBacklogService.getAvailableUserStories(productBacklog));
		}

		if (releaseBacklog.getUserStories().size() > 0) {
			model.addAttribute("userStoryList", releaseBacklog.getUserStories());
		}
		
		if (releaseBacklog.getSprints().size() > 0) {
			model.addAttribute("sprintList", releaseBacklog.getSprints());
		}

		UserStory userStory = new UserStory();
		Sprint sprint = new Sprint();
		model.addAttribute("userstory", userStory);
		model.addAttribute("productbacklog", productBacklog);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("sprint", sprint);
		model.addAttribute("buttonTitle", "Add");
		model.addAttribute("page", "releaseBacklog/releaseBacklogDetails");

		return "dashboard";
	}
	

	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/userstory/add/{userStoryId}", method = RequestMethod.GET)
	public String assignUserStories(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId,
			@PathVariable int userStoryId) {

		Release release = releaseBacklogService.getReleaseById(releaseBacklogId);

		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		userStory.setReleaseBacklog(release);

		userStoryService.updateUserStory(userStory);

		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/userstory/remove/{userStoryId}", method = RequestMethod.GET)
	public String removeUserStories(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId,
			@PathVariable int userStoryId) {

		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		userStory.setReleaseBacklog(null);

		userStoryService.updateUserStory(userStory);

		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}";
	}

}
