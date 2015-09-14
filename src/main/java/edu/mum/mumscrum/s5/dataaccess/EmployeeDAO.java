package edu.mum.mumscrum.s5.dataaccess;

import java.util.List;

import edu.mum.mumscrum.s5.entity.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee p);
	public void updateEmployee(Employee p);
	public List<Employee> listEmployees();
	public Employee getEmployeeById(int id);
	public void removeEmployee(int id);
}
