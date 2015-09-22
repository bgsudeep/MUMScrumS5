package edu.mum.mumscrum.s5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.Sprint;
import edu.mum.mumscrum.s5.service.ProductBacklogService;
import edu.mum.mumscrum.s5.service.ReleaseBacklogService;
import edu.mum.mumscrum.s5.service.RoleService;
import edu.mum.mumscrum.s5.service.SprintService;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Controller

public class SprintController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SprintController.class);

	@Autowired
	private ReleaseBacklogService releaseBacklogService;

	@Autowired
	private ProductBacklogService productBacklogService;

	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SprintService sprintService;
	//
	// @Autowired
	// private ReleaseBacklogService releaseBacklogService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listSprints(Model model) {
		return "dashboard";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/add", method = RequestMethod.POST)
	public String createSprint(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @ModelAttribute("sprint") Sprint sprint) {
		
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		sprint.setReleaseBacklog(releaseBacklog);
		this.sprintService.addSprint(sprint);

		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}";
	}
	

}
