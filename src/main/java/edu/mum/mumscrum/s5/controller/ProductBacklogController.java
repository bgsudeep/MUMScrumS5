package edu.mum.mumscrum.s5.controller;

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

import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.service.ProductBacklogService;
import edu.mum.mumscrum.s5.service.ReleaseBacklogService;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Controller
@RequestMapping("/productbacklog")
public class ProductBacklogController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductBacklogController.class);
	
	@Autowired
	private ProductBacklogService productBacklogService;

	@Autowired
	private UserStoryService userStoryService;
	
	@Autowired
	private ReleaseBacklogService releaseBacklogService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listProductBacklogs(Model model) {
		LOGGER.debug("Processing request for /productbacklog");
		model.addAttribute("productbacklog", new ProductBacklog());
		model.addAttribute("page", "productBacklog/productbacklog");
		model.addAttribute("productBacklogList", this.productBacklogService.listProductBacklog());
		return "dashboard";
	}
	
//	@RequestMapping(value = {"/{productBacklogId}/userstory/add", "/{productBacklogId}/details/userstory/add"}, method = RequestMethod.POST)
//	public String saveUserStory(@PathVariable("productBacklogId") int id,
//			@ModelAttribute("userstory") UserStory userStory,
//			BindingResult result, RedirectAttributes redir) {
//
//		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(id);
//
//		userStory.setProductBacklog(productBacklog);
//		userStoryService.addUserStory(userStory);
//
//		redir.addFlashAttribute("message", "New user story added!!!");
//
//		/*
//		 * Note that there is no slash "/" right after "redirect:" So, it
//		 * redirects to the path relative to the current path
//		 */
//		return "redirect:/productbacklog/" + id + "/details/";
//	}
	
//	@RequestMapping(value = {"/{productBacklogId}/release/add", "/{productBacklogId}/details/release/add"}, method = RequestMethod.POST)
//	public String saveRelease(@PathVariable("productBacklogId") int id,
//			@ModelAttribute("releasebacklog") Release releaseBacklog,
//			BindingResult result, RedirectAttributes redir) {
//
//		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(id);
//
//		releaseBacklog.setProductBacklog(productBacklog);
//		releaseBacklogService.addRelease(releaseBacklog);
//
//		redir.addFlashAttribute("message", "New user story added!!!");
//
//		/*
//		 * Note that there is no slash "/" right after "redirect:" So, it
//		 * redirects to the path relative to the current path
//		 */
//		return "redirect:/productbacklog/" + id + "/details/";
//	}
	
	@RequestMapping("/{productBacklogId}")
	public String getProductBacklogDetails(@PathVariable int productBacklogId,
			Model model) {
		ProductBacklog productBacklog = productBacklogService.getProductBacklogById(productBacklogId);
		if(productBacklog.getUserStories().size() > 0) {
			model.addAttribute("userStoryList", productBacklog.getUserStories());
		}
		if(productBacklog.getReleases().size() > 0) {
			model.addAttribute("releaseBacklogList", productBacklog.getReleases());
		}
		
		UserStory userStory = new UserStory();
		Release releaseBacklog = new Release();
		model.addAttribute("userstory", userStory);
		model.addAttribute("releasebacklog", releaseBacklog);
		model.addAttribute("productbacklog", productBacklog);
		model.addAttribute("buttonTitle", "Add");
		model.addAttribute("page", "productBacklog/productBacklogDetails");

		return "dashboard";
	}
	
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addProductBacklog(@ModelAttribute("productbacklog") ProductBacklog pb){
		LOGGER.debug("Processing request for /employee/add");
		
		if(pb.getId() == 0){
			//new employee, add it
			this.productBacklogService.addProductBacklog(pb);;
		}else{
			//existing employee, call update
			this.productBacklogService.updateProductBacklog(pb);
		}
		//add the product backlog in the database
		return "redirect:/productbacklog/";
		
	}
	

	public ProductBacklogService getProductBacklogService() {
		return productBacklogService;
	}

	public void setProductBacklogService(ProductBacklogService productBacklogService) {
		this.productBacklogService = productBacklogService;
	}

	
}
