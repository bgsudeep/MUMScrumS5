package edu.mum.mumscrum.s5.service;

import java.util.List;

import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.ProductBacklog;

public interface EmployeeService {

	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public List<Employee> listEmployee();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
	
}
