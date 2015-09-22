package edu.mum.mumscrum.s5.dataaccess;

import java.util.List;

import edu.mum.mumscrum.s5.entity.Sprint;

public interface SprintDAO {
	public void addSprint(Sprint sprint);
	public void updateSprint(Sprint sprint);
	public Sprint getSprintById(int id);
	public List<Sprint> listSprint();
}
