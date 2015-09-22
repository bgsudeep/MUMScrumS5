package edu.mum.mumscrum.s5.service;

import java.util.List;

import edu.mum.mumscrum.s5.entity.Sprint;

public interface SprintService {
	public void addSprint(Sprint sprint);
	public void updateSprint(Sprint sprint);
	public Sprint getSprintById(int id);
	public List<Sprint> listSprint();
	public void removeSprint(int id);
}
