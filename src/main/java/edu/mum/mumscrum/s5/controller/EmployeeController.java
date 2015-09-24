package edu.mum.mumscrum.s5.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.Role;
import edu.mum.mumscrum.s5.entity.User;
import edu.mum.mumscrum.s5.service.EmployeeService;
import edu.mum.mumscrum.s5.service.RoleService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		LOGGER.debug("Processing request for /employee");
		
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployee());
		model.addAttribute("page", "employee/employee");
		return "dashboard";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addEmp(Model model) {
		LOGGER.debug("Processing request for /employee/add GET");
		model.addAttribute("employee", new Employee());
		
		for (Role role : roleService.getRoles()) {
			System.out.println("Role: " + role.getRole());
		}
		
		model.addAttribute("roles", roleService.getRoles());
		model.addAttribute("page", "employee/addemployee");
		return "dashboard";
	}
	
	//For add and update person both
	@RequestMapping(value= "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee e){
		LOGGER.debug("Processing request for /employee/add");
		
		if(e.getId() == 0){
			//new employee, add it
			String roleID = e.getUser().getRoleID();
			Role role = roleService.getRoleById(Integer.valueOf(roleID));
			e.getUser().addRole(role);
			this.employeeService.addEmployee(e);
		}else{
			//existing employee, call update
			Employee dbEmployee = employeeService.getEmployeeById(e.getId());
			
			copyProperties(e, dbEmployee);
			
			this.employeeService.updateEmployee(dbEmployee);
		}
		
		return "redirect:/employee/";
		
	}
	
	private void copyProperties(Employee source, Employee destination) {

		destination.setFirstName(source.getFirstName());
		destination.setLastName(source.getLastName());
		destination.setEmail(source.getEmail());
		destination.setTelephone(source.getTelephone());
		destination.setStreet(source.getStreet());
		destination.setCity(source.getCity());
		destination.setState(source.getState());
		destination.setZip(source.getZip());
		destination.setSalary(source.getSalary());
		destination.setJoinDate(source.getJoinDate());
	}
	
	@RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		LOGGER.debug("Processing request for /employee/remove");

		try {
			this.employeeService.removeEmployee(id);
		}
		catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
        return "redirect:/employee/";
    }
 
    @RequestMapping("/edit/{id}")
    public String editEmployee(@PathVariable("id") int id, Model model){
		LOGGER.debug("Processing request for /employee/edit");

		Employee e = this.employeeService.getEmployeeById(id);
		
		model.addAttribute("employee", e);
		
		for (Role role : roleService.getRoles()) {
			System.out.println("Role: " + role.getRole());
			for (User user : role.getUserRoles()) {
				if(e.getUser().getId() == user.getId()) {
					model.addAttribute("roleID", role.getId() + "");
				}
			}
		}
		
		model.addAttribute("roles", roleService.getRoles());
		model.addAttribute("page", "employee/editemployee");
        return "dashboard";
    }
    
    @RequestMapping(value = "/employeeprofile", method = RequestMethod.GET)
    public String employeeProfile(Model model, HttpSession session) {
    	Employee emp = (Employee) session.getAttribute("loggedInEmployee");
    	model.addAttribute("empName", emp);
    	model.addAttribute("page", "employee/employeeprofile");
    	return "dashboard";
    }
    
    public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
}
