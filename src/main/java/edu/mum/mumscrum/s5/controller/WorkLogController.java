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

import edu.mum.mumscrum.s5.dataaccess.WorkLogEffortDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.entity.WorkLog;
import edu.mum.mumscrum.s5.service.EmployeeService;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Controller
public class WorkLogController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkLogController.class);
	
	@Autowired
	WorkLogEffortDAO workLogDAO;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	UserStoryService userStoryService;
	
	@RequestMapping(value = "/userEffortLog/{userstoryId}/{loggedInEmployeeId}", method = RequestMethod.GET)
	public String createEffortLog(@PathVariable int userstoryId, @PathVariable int loggedInEmployeeId, Model model)
	{
		LOGGER.debug("Processing request for /worklog");
		model.addAttribute("userstoryId", userstoryId);
		model.addAttribute("employeeId", loggedInEmployeeId);
		
		model.addAttribute("page", "updateEmployeeEffort");
		
		return "dashboard";
	}
	
	@RequestMapping(value = "/userEffortLog/{userstoryId}/{loggedInEmployeeId}", method = RequestMethod.POST)
	public String createEffortLog(@PathVariable int userstoryId, @PathVariable int loggedInEmployeeId, @ModelAttribute("worklog") WorkLog workLog, Model model)
	{
		LOGGER.debug("Processing request for /worklog");
		UserStory userStory = userStoryService.getUserStoryById(userstoryId);
		
		userStory.setRemainingDevHours(userStory.getRemainingDevHours() - workLog.getActualEffort_Dev());
		userStoryService.updateUserStory(userStory);
		Employee employee = employeeService.getEmployeeById(loggedInEmployeeId);

		workLogDAO.addWorkLog(workLog);
		model.addAttribute("assignedUserStories", employee.getUserStoriesForDeveloper());
		model.addAttribute("page", "main-developer");
		return "/dashboard";
	}
	
	
	
	
	
	
}
