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
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/userstory/add", method = RequestMethod.POST)
	public String saveUserStory(@PathVariable("productBacklogId") int id,
			@ModelAttribute("userstory") UserStory userStory,
			BindingResult result, RedirectAttributes redir) {

		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(id);

		userStory.setProductBacklog(productBacklog);
		userStoryService.addUserStory(userStory);

		redir.addFlashAttribute("message", "New user story added!!!");

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:/productbacklog/" + id;
	}

}
