package edu.mum.mumscrum.s5.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.EmployeeDAO;
import edu.mum.mumscrum.s5.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		entityManager.flush();
		LOGGER.info("Employee saved successfully, Employee Details=" + employee);
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
		LOGGER.info("Employee to be updated = " + employee);
		entityManager.merge(employee);
		LOGGER.info("Employee updated successfully, Employee Details=" + employee);
	}

	@Override
	@Transactional
	public List<Employee> listEmployees() {
		List<Employee> employeeList = entityManager.createQuery("select o from Employee o where o.id > 1", Employee.class).getResultList();
		
		for(Employee e : employeeList){
			LOGGER.info("Employee List::" + e);
		}
		return employeeList;
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		Employee e = (Employee) entityManager.find(Employee.class, new Integer(id));
		LOGGER.info("Employee loaded successfully, Employee details=" + e);
		return e;
	}

	@Override
	@Transactional
	public void removeEmployee(int id) {
		Employee e = getEmployeeById(id);
		if(null != e){
			entityManager.remove(e);
		}
		LOGGER.info("Employee deleted successfully, employee details=" + e);
	}

}
