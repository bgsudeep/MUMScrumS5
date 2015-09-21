package edu.mum.mumscrum.s5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.Sprint;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.service.ProductBacklogService;
import edu.mum.mumscrum.s5.service.ReleaseBacklogService;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Controller
@RequestMapping("/releasebacklog")

public class ReleaseBacklogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseBacklogController.class);

	@Autowired
	private ReleaseBacklogService releaseBacklogService;

	@Autowired
	private ProductBacklogService productBacklogService;

	@Autowired
	private UserStoryService userStoryService;
	//
	// @Autowired
	// private ReleaseBacklogService releaseBacklogService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listReleaseBacklogs(Model model) {
		LOGGER.debug("Processing request for /releasebacklog");
		model.addAttribute("releasebacklog", new Release());
		model.addAttribute("page", "releaseBacklog/releasebacklog");
		model.addAttribute("productBacklogList", this.productBacklogService.listProductBacklog());
		return "dashboard";
	}

	@RequestMapping("/{releaseBacklogId}/details/productbacklog/{productBacklogId}")
	public String getProductBacklogDetails(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId,
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
		Sprint sprint = new Sprint();
		model.addAttribute("userstory", userStory);
		model.addAttribute("productbacklog", productBacklog);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("sprint", sprint);
		model.addAttribute("page", "releaseBacklog/releaseBacklogDetails");

		return "dashboard";
	}

	@RequestMapping(value = "/{releaseBacklogId}/details/productbacklog/{productBacklogId}/userstory/add/{userStoryId}", method = RequestMethod.GET)
	public String assignUserStories(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId,
			@PathVariable int userStoryId) {

		Release release = releaseBacklogService.getReleaseById(releaseBacklogId);

		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		userStory.setReleaseBacklog(release);

		userStoryService.updateUserStory(userStory);

		return "redirect:/releasebacklog/{releaseBacklogId}/details/productbacklog/{productBacklogId}";
	}
	
	@RequestMapping(value = "/{releaseBacklogId}/details/productbacklog/{productBacklogId}/userstory/remove/{userStoryId}", method = RequestMethod.GET)
	public String removeUserStories(@PathVariable int releaseBacklogId, @PathVariable int productBacklogId,
			@PathVariable int userStoryId) {

		UserStory userStory = userStoryService.getUserStoryById(userStoryId);
		userStory.setReleaseBacklog(null);

		userStoryService.updateUserStory(userStory);

		return "redirect:/releasebacklog/{releaseBacklogId}/details/productbacklog/{productBacklogId}";
	}

}
