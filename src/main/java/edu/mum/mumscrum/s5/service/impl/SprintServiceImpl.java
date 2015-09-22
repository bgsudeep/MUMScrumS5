package edu.mum.mumscrum.s5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.EmployeeDAO;
import edu.mum.mumscrum.s5.dataaccess.SprintDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.Sprint;
import edu.mum.mumscrum.s5.service.EmployeeService;
import edu.mum.mumscrum.s5.service.SprintService;

@Service
public class SprintServiceImpl implements SprintService {
	
	@Autowired
	private SprintDAO sprintDAO;

	@Override
	public void addSprint(Sprint sprint) {
		this.sprintDAO.addSprint(sprint);
	}

	@Override
	public void updateSprint(Sprint sprint) {
		this.sprintDAO.updateSprint(sprint);
	}

	@Override
	public Sprint getSprintById(int id) {
		return this.sprintDAO.getSprintById(id);
	}

	@Override
	public List<Sprint> listSprint() {
		return this.sprintDAO.listSprint();
	}

	@Override
	public void removeSprint(int id) {
		this.sprintDAO.removeSprint(id);
	}
	
	
}
