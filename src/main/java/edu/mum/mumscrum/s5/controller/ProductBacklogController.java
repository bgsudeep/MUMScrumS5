package edu.mum.mumscrum.s5.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Role;
import edu.mum.mumscrum.s5.service.EmployeeService;
import edu.mum.mumscrum.s5.service.ProductBacklogService;

@Controller
public class ProductBacklogController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductBacklogController.class);
	
	@Autowired
	private ProductBacklogService productBacklogService;

	@RequestMapping(value = "/productbacklog", method = RequestMethod.GET)
	public String listProductBacklogs(Model model) {
		LOGGER.debug("Processing request for /productbacklog");
		model.addAttribute("productbacklog", new ProductBacklog());
		
		model.addAttribute("productBacklogList", this.productBacklogService.listProductBacklog());
		return "/productbacklog";
	}
	
	@RequestMapping(value= "/productbacklog/add", method = RequestMethod.POST)
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
		return "redirect:/productbacklog";
		
	}

	public ProductBacklogService getProductBacklogService() {
		return productBacklogService;
	}

	public void setProductBacklogService(ProductBacklogService productBacklogService) {
		this.productBacklogService = productBacklogService;
	}

	
}
