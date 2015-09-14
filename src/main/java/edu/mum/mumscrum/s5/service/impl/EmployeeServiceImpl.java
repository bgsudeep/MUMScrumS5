package edu.mum.mumscrum.s5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.EmployeeDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public void setemployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void addEmployee(Employee e) {
		this.employeeDAO.addEmployee(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		this.employeeDAO.updateEmployee(e);
	}

	@Override
	public List<Employee> listEmployee() {
		return this.employeeDAO.listEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return this.employeeDAO.getEmployeeById(id);
	}

	@Override
	public void removeEmployee(int id) {
		this.employeeDAO.removeEmployee(id);
	}

}
