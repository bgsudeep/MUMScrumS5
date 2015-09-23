package edu.mum.mumscrum.s5.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.Sprint;
import edu.mum.mumscrum.s5.entity.UserStory;
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

	
	
	@RequestMapping(value = "/sprint", method = RequestMethod.GET)
	public String listSprints(Model model) {
		model.addAttribute("page", "sprint/sprint");
		List<String> numbers = Arrays.asList("Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");
		String strCollapse = "collapse";
		String strHeading = "heading";
		
		List<String> collapse = new ArrayList<String>();
		List<String> heading = new ArrayList<String>();
		
		for (int i = 1; i <= this.releaseBacklogService.listRelease().size(); i++) {
			collapse.add(strCollapse+numbers.get(i));
			heading.add(strHeading+numbers.get(i));
		}
		
		model.addAttribute("productBacklogList", this.productBacklogService.listProductBacklog());
		model.addAttribute("heading", heading);
		model.addAttribute("collapse", collapse);
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintID}/edit", method = RequestMethod.GET)
	public String getEditSprint(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @PathVariable int sprintID,
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
	
	
	
	
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/save", method = RequestMethod.POST)
	public String saveSprint(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @ModelAttribute("sprint") Sprint sprint) {
		
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		sprint.setReleaseBacklog(releaseBacklog);
		
		if(sprint.getId() == 0) {
			this.sprintService.addSprint(sprint);
		}
		else {
			this.sprintService.updateSprint(sprint);
		}
		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/delete")
    public String removeSprint(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @PathVariable int sprintId){

		try {
			this.sprintService.removeSprint(sprintId);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
        return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}";
    }
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}")
    public String getSprintDetails(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @PathVariable int sprintId, Model model){
		Release releaseBacklog = releaseBacklogService.getReleaseById(releaseBacklogId);
		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(productBacklogId);
		Sprint sprint = sprintService.getSprintById(sprintId);
		
		if (this.releaseBacklogService.getAvailableUserStories(releaseBacklog).size() > 0) {
			model.addAttribute("availableUserStories", releaseBacklogService.getAvailableUserStories(releaseBacklog));
		}

		if (sprint.getUserStories().size() > 0) {
			model.addAttribute("userStoryList", sprint.getUserStories());
		}
		
		if (releaseBacklog.getSprints().size() > 0) {
			model.addAttribute("sprintList", releaseBacklog.getSprints());
		}

		model.addAttribute("productbacklog", productBacklog);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("sprint", sprint);
		model.addAttribute("buttonTitle", "Add");
		model.addAttribute("page", "sprint/sprintDetails");
		
		
		return "dashboard";
    }
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/userstory/add/{userStoryId}", method = RequestMethod.GET)
	public String assignUserStoriesToSprint(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @PathVariable int sprintId,
			@PathVariable int userStoryId) {

		Release release = releaseBacklogService.getReleaseById(releaseBacklogId);
		Sprint sprint = sprintService.getSprintById(sprintId);
		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		userStory.setSprint(sprint);

		userStoryService.updateUserStory(userStory);

		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}";
	}
	
	@RequestMapping(value = "/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}/userstory/remove/{userStoryId}", method = RequestMethod.GET)
	public String removeUserStoriesToSprint(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId, @PathVariable int sprintId,
			@PathVariable int userStoryId) {

		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		userStory.setSprint(null);

		userStoryService.updateUserStory(userStory);

		return "redirect:/productbacklog/{productBacklogId}/releasebacklog/{releaseBacklogId}/sprint/{sprintId}";
	}

}
