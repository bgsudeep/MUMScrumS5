package edu.mum.mumscrum.s5.dataaccess.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.SprintDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Sprint;
import edu.mum.mumscrum.s5.entity.UserStory;

@Repository
public class SprintDAOImpl implements SprintDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(SprintDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addSprint(Sprint sprint) {
		entityManager.persist(sprint);
		entityManager.flush();
		LOGGER.info("Employee saved successfully, Employee Details=" + sprint);
	}

	@Override
	@Transactional
	public void updateSprint(Sprint sprint) {
		LOGGER.info("Sprint to be updated = " + sprint);
		entityManager.merge(sprint);
		LOGGER.info("Sprint updated successfully, Sprint Details=" + sprint);
		
	}

	@Override
	@Transactional
	public Sprint getSprintById(int id) {
		Sprint sprint = (Sprint) entityManager.find(Sprint.class, new Integer(id));
		LOGGER.info("Sprint loaded successfully, Sprint details=" + sprint);
		return sprint;
	}

	@Override
	@Transactional
	public List<Sprint> listSprint() {
		List<Sprint> sprintList = entityManager.createQuery("select o from Spring o", Sprint.class).getResultList();
		for(Sprint sprint : sprintList) {
			LOGGER.info("Sprint List::" + sprint);
		}
		return sprintList;
	}

	@Override
	@Transactional
	public void removeSprint(int id) {
		Sprint sprint = getSprintById(id);
		if(null != sprint){
			entityManager.remove(sprint);
		}
		LOGGER.info("Sprint deleted successfully, sprint details=" + sprint);
	}
}
