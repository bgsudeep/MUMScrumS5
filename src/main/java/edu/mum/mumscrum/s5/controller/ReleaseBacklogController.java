package edu.mum.mumscrum.s5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.service.ProductBacklogService;

@Controller
@RequestMapping("/releasebacklog")
public class ReleaseBacklogController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseBacklogController.class);
	
	@Autowired
	private ProductBacklogService productBacklogService;

//	@Autowired
//	private UserStoryService userStoryService;
//	
//	@Autowired
//	private ReleaseBacklogService releaseBacklogService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listReleaseBacklogs(Model model) {
		LOGGER.debug("Processing request for /releasebacklog");
		model.addAttribute("releasebacklog", new Release());
		model.addAttribute("page", "releaseBacklog/releasebacklog");
		model.addAttribute("productBacklogList", this.productBacklogService.listProductBacklog());
		return "dashboard";
	}
		
}
